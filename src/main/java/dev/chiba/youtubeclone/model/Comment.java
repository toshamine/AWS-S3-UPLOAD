package dev.chiba.youtubeclone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Comment {

    @Id
    private String id;
    private String text;
    private Integer likes;
    private Integer dislikes;
}
