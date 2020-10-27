package com.doruareabe.manko_webstore.entity.mattressEntity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mattress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "Nie może być puste")
    String name;
    @NotBlank(message = "Nie może być puste")
    String description;
    @NotNull
    @ManyToOne
    Cover cover;
    @ManyToMany
    Set<ExtraComponent> extraComponents = new LinkedHashSet<>();
    @NotNull
    @ManyToOne
    Type type;
    @ManyToOne
    Dimension dimensions;
    @ManyToOne
    Density density;
    @NotNull
    @Pattern(regexp="[0-9]+\\.?[0-9]{0,2}", message = "Musi mieć format xxx.xx gdzie x - liczba od 0 do 9")
    String price;
    @NotNull
    Boolean availability = false;
    String img;
}
