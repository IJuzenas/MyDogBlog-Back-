package com.app.App.services;

import com.app.App.entities.ElementDto;

import java.util.List;

public interface ElementService {
    List<ElementDto> getAllElements();

    String createElement(ElementDto elementDto);
}
