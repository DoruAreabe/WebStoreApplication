package com.doruareabe.manko_webstore.repository.mattress;

import com.doruareabe.manko_webstore.entity.mattressEntity.Mattress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MattressRepository extends JpaRepository<Mattress,Long> {
    @Query("select m from Mattress m join fetch m.cover join fetch m.density join fetch m.dimensions join fetch m.extraComponents join fetch m.type where m.id = :id")
    Mattress getMattressWithAllFieldsById(@Param("id") Long id);
}
