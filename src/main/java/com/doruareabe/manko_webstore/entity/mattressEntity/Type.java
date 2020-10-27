package com.doruareabe.manko_webstore.entity.mattressEntity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    @NotBlank(message = "Nie może być puste")
    String typ;
    @OneToMany(mappedBy = "type")
    List<Mattress> mattresses = new ArrayList<>();
}
