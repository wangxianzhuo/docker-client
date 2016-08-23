package com.github.wangxianzhuo.docker.controller;

import com.github.wangxianzhuo.docker.model.Image;
import com.github.wangxianzhuo.docker.service.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 * ImageController
 * Created by shangjie
 * 16-8-23
 */
@Controller
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;

    @RequestMapping(value = "/images/json", method = RequestMethod.GET)
    public ResponseEntity<String> all() {
//        Image image = imageRepository.all();
//        System.out.println(image);
        return ResponseEntity.ok("{}");
    }
}
