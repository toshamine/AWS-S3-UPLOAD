package dev.chiba.youtubeclone.service;

import dev.chiba.youtubeclone.dto.VideoDTO;
import dev.chiba.youtubeclone.dto.VideoResponse;
import dev.chiba.youtubeclone.exception.VideoException;
import dev.chiba.youtubeclone.model.Video;
import dev.chiba.youtubeclone.repo.VideoRepo;
import dev.chiba.youtubeclone.utility.VideoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final S3Service s3Service;
    private final VideoRepo videoRepo;

    public VideoResponse uploadVideo(MultipartFile file){
        String videoUrl = s3Service.upload(file);
        Video video = Video.builder()
                .videoUrl(videoUrl)
                .build();
        video = videoRepo.save(video);
        return VideoResponse.builder()
                .videoUrl(videoUrl)
                .videoId(video.getId())
                .build();
    }

    public VideoDTO updateVideoMetaData(VideoDTO videoDTO){
        if(!videoRepo.existsById(videoDTO.getId()))
            throw VideoException.NOT_FOUND;

        Video video = VideoMapper.mapVideoToVideoDto(videoDTO);
        videoRepo.save(video);
        return videoDTO;
    }

    public String uploadThumbNail(MultipartFile file,String videoId){
        if(!videoRepo.existsById(videoId))
            throw VideoException.NOT_FOUND;

        Video savedVideo = videoRepo.findById(videoId)
                .orElseThrow(() -> VideoException.NOT_FOUND);

        String thumbNailUrl = s3Service.upload(file);
        savedVideo.setThumbnailUrl(thumbNailUrl);
        videoRepo.save(savedVideo);
        return thumbNailUrl;
    }



}
