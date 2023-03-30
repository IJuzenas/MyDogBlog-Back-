package com.app.App.services;

import com.app.App.entities.Element;
import com.app.App.entities.ElementDto;
import com.app.App.entities.ImageData;
import com.app.App.repositories.ElementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElementServiceImpl implements ElementService {

    private final ElementRepository elementRepository;
    @Override
    public List<ElementDto> getAllElements() {
        return mapToDto(elementRepository.getAllElements());
    }
    @Override
    public String createElement(ElementDto elementDto) {
        Element newElement = buildNewElement(elementDto);
        elementRepository.save(newElement);
        return "New element has been created";
    }
    private Element buildNewElement(ElementDto elementDto) {
        return Element.builder()
                .id(elementDto.getId())
                .name(elementDto.getName())
                .imageData(elementDto.getImageData())
                .imageUrl(elementDto.getImageUrl())
                .build();
    }
        private ImageData buildNewImageData(byte[] data) {
            return ImageData.builder()
                    .data(data)
                    .build();
        }

    private List<ElementDto> mapToDto(Collection<Element> entities) {
        return entities.stream()
                .map(o ->ElementDto.builder()
                        .id(o.getId())
                        .name(o.getName())
                        .imageData(o.getImageData())
                        .imageUrl(o.getImageUrl())
                        .build())
                .collect(Collectors.toList());
    }
}
