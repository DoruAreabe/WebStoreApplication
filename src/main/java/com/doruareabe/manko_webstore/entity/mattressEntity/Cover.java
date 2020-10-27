package com.doruareabe.manko_webstore.entity.mattressEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    @NotBlank(message = "Nie może być puste")
    String covr;
    @OneToMany(mappedBy = "cover")
    Set<Mattress> mattresses = new LinkedHashSet<>();
}
