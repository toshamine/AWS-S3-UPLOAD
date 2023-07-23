package dev.chiba.youtubeclone.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public String upload(MultipartFile multipartFile);
}
