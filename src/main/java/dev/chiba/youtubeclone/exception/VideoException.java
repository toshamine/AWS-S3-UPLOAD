package dev.chiba.youtubeclone.exception;

import dev.chiba.youtubeclone.model.Video;

public class VideoException extends RuntimeException{

    public static final VideoException NOT_FOUND = new VideoException("Vide not found !");

    public VideoException(String message) {
        super(message);
    }
}
