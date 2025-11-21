package com.bezkoder.spring.webflux.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tutorial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private Boolean published;    
}
