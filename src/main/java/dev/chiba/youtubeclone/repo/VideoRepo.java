package dev.chiba.youtubeclone.repo;

import dev.chiba.youtubeclone.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepo extends MongoRepository<Video,String> {

}
