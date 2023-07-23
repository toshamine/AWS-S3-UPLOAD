package dev.chiba.youtubeclone.controller;


import dev.chiba.youtubeclone.dto.VideoDTO;
import dev.chiba.youtubeclone.dto.VideoResponse;
import dev.chiba.youtubeclone.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/videos")
@RequiredArgsConstructor
@CrossOrigin("localhost:4200")
public class VideoController {

    private final VideoService videoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VideoResponse upload(@RequestParam("file") MultipartFile multipartFile){
        return videoService.uploadVideo(multipartFile);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public VideoDTO updateVideoMetaData(@RequestBody VideoDTO videoDTO){
        return videoService.updateVideoMetaData(videoDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadThumbNail(@RequestParam("file") MultipartFile multipartFile,@RequestParam("videoId") String videoId){
        return videoService.uploadThumbNail(multipartFile,videoId);
    }
}
