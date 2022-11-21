package com.example.javaee_project.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductDTO {
    @Nullable
    private String name;
    @Nullable
    private Double price;
    @Nullable
    private MultipartFile image;
}
