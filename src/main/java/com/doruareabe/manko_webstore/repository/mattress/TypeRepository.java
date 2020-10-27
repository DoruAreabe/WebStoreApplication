package com.doruareabe.manko_webstore.repository.mattress;

import com.doruareabe.manko_webstore.entity.mattressEntity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
}
