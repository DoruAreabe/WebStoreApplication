package com.doruareabe.manko_webstore.repository;

import com.doruareabe.manko_webstore.entity.EmailDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDBRepository extends JpaRepository<EmailDB,Long> {
}
