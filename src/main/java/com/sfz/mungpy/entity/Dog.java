package com.sfz.mungpy.entity;

import com.sfz.mungpy.dto.DogMatchDto;
import com.sfz.mungpy.dto.DogSpecificDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "dogs")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int age;
    private String sex;
    private String kind;
    private String name;
    private String image;
    private String personality;
    private String description;
    @Column(name = "match_reason")
    private String matchReason;
    @Column(name = "rescue_place")
    private String rescuePlace;
    @Column(name = "protect_place")
    private String protectPlace;
    @Column(name = "protect_telno")
    private String protectTelno;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    public DogMatchDto toMatchDto() {
        return DogMatchDto.builder()
                .id(id)
                .name(name)
                .image(image)
                .description(description)
                .matchReason(matchReason)
                .build();
    }

    public DogSpecificDto toDogSpecificDto() {
        return DogSpecificDto.builder()
                .age(age)
                .sex(sex)
                .name(name)
                .image(image)
                .personality(Arrays.stream(personality.split(", ")).toList())
                .rescuePlace(rescuePlace)
                .protectPlace(protectPlace)
                .protectTelno(protectTelno)
                .expirationDate(expirationDate)
                .build();
    }
}