package com.doruareabe.manko_webstore.repository;

import com.doruareabe.manko_webstore.entity.ToContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToContactRepository extends JpaRepository<ToContact, Long> {
}
