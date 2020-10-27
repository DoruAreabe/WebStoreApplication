package com.doruareabe.manko_webstore.repository.mattress;

import com.doruareabe.manko_webstore.entity.mattressEntity.ExtraComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraComponentRepository extends JpaRepository<ExtraComponent,Long> {
}
