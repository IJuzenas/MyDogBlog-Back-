package com.app.App.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementDto {
    private Long id;
    private String name;
    @Lob
    private byte [] imageData;

    private String imageUrl;
}

