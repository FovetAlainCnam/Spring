package com.example.demo.repositories;

import com.example.demo.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findByTitle(String title);
    List<Video> findByUserId(int id);
}
