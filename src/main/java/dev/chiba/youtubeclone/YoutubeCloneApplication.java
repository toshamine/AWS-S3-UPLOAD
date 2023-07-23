package dev.chiba.youtubeclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class YoutubeCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoutubeCloneApplication.class, args);
	}



	public int maxArea(int[] height) {
		int max = Arrays.stream(height)
				.max()
				.getAsInt();
		long maxOcc = Arrays.stream(height)
				.filter(number -> number == max)
				.count();

		return maxOcc == 1 ? (int) Math.pow(Arrays.stream(height)
				.filter(number -> number != max)
				.max()
				.orElse(max),2)
				: (int) Math.pow(max,2);
	}


}
