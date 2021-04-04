package com.example.demo.controllers;

import com.example.demo.models.Video;
import com.example.demo.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/videos")
public class VideoController extends AbstractController {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    public VideoController(VideoRepository videoRepository) {
        super(videoRepository);
    }

    @PostMapping
    public Video save(Video video) {
        return (Video) crudFactoryService.performService(video, videoRepository, "create");
    }
}
