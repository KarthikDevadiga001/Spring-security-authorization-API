package com.androidventures.UniMealServer.springboot.models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyMember {
    private int age;
    private String name;
    private int height;
    private Float weight;
    private List<String> allergies;
    private List<String> healthconditions;
}
