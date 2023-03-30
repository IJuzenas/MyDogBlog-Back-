package com.app.App.controllers;

import com.app.App.entities.ElementDto;
import com.app.App.entities.ImageData;
import com.app.App.services.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.awt.*;
import java.io.File;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/elements")
public class ElementController {

    private final ElementService elementService;

    @GetMapping("/all")
    public List<ElementDto> getAllElements() {
        return elementService.getAllElements();
    }
    @PostMapping
    public String createElement(@RequestBody ElementDto element) {
        return elementService.createElement(element);
    }
    @PostMapping("/create")
    public String createElement(Long id,
                                @RequestParam("name") String name,
                                @RequestParam("imagePreview") String imageUrl,
                                @RequestParam("imageData") MultipartFile imageData) throws IOException {
        ElementDto elementDto = ElementDto.builder()
                .id(id)
                .name(name)
                .imageUrl(imageUrl)
                .imageData(imageData.getBytes())
                .build();

        return elementService.createElement(elementDto);
    }
}
