package com.doruareabe.manko_webstore.entity.mattressEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    @NotBlank(message = "Nie może być puste")
    @Pattern(regexp = "[0-9]{3}x[0-9]{3}x[0-9]{2}", message = "Musi być w formacie NNNxNNNxNN gdzie N - liczba od 0 do 9")
    String dimension;
    @OneToMany(mappedBy = "dimensions")
    Set<Mattress> mattresses = new LinkedHashSet<>();
}
