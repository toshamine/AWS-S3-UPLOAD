package dev.chiba.youtubeclone.service;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service implements FileService{

    private final static String BUCKET_NAME = "youtube-clone";
    private final AmazonS3Client amazonS3Client;

    @Override
    public String upload(MultipartFile multipartFile) {

        var fileExtension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
        var key = UUID.randomUUID().toString() + fileExtension;
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());

        try{
            amazonS3Client.putObject(BUCKET_NAME,key,multipartFile.getInputStream(),metadata);
        }
        catch (IOException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Can't upload file to S3 Bucket !");
        }
        amazonS3Client.setBucketAcl(BUCKET_NAME, CannedAccessControlList.PublicRead);
        return amazonS3Client.getResourceUrl(BUCKET_NAME,key);
    }
}
