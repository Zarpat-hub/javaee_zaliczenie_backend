package com.example.javaee_project.models.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class OrderDTO {
    private ArrayList<Integer> productIds;
    private String username;
}
