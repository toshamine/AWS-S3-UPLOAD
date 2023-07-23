package dev.chiba.youtubeclone.utility;

import dev.chiba.youtubeclone.dto.VideoDTO;
import dev.chiba.youtubeclone.model.Video;

public class VideoMapper {

    public static Video mapVideoToVideoDto(VideoDTO videoDTO){
        return Video.builder()
                .id(videoDTO.getId())
                .title(videoDTO.getTitle())
                .description(videoDTO.getDescription())
                .videoUrl(videoDTO.getVideoUrl())
                .thumbnailUrl(videoDTO.getThumbnailUrl())
                .tags(videoDTO.getTags())
                .build();
    }
}
