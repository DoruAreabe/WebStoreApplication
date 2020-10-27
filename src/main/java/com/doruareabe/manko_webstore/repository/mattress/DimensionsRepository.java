package com.doruareabe.manko_webstore.repository.mattress;

import com.doruareabe.manko_webstore.entity.mattressEntity.Dimension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Repository
public interface DimensionsRepository extends JpaRepository<Dimension,Long> {
    Dimension findDimensionByDimension(String dimension);
}
