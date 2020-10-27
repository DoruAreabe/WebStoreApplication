package com.doruareabe.manko_webstore.entity.mattressEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExtraComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    @NotBlank(message = "Nie może być puste")
    String extraComponent;
    @ManyToMany(mappedBy = "extraComponents")
    Set<Mattress> mattresses = new LinkedHashSet<>();
}
