package com.example.ptmedia.repository;

import com.example.ptmedia.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate , Long> {
}
