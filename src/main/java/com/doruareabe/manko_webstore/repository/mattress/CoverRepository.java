package com.doruareabe.manko_webstore.repository.mattress;

import com.doruareabe.manko_webstore.entity.mattressEntity.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;

@Repository
public interface CoverRepository extends JpaRepository<Cover,Long> {
    Cover findCoverByCovr(@NotBlank(message = "Nie może być puste") String covr);
}
