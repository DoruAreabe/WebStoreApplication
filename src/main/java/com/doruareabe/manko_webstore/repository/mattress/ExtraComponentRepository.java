package com.doruareabe.manko_webstore.repository.mattress;

import com.doruareabe.manko_webstore.entity.mattressEntity.ExtraComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;

@Repository
public interface ExtraComponentRepository extends JpaRepository<ExtraComponent,Long> {
    ExtraComponent findExtraComponentByExtraComponent(String extraComponent);
}
