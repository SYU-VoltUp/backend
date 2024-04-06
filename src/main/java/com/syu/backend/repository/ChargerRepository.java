package com.syu.backend.repository;

import com.syu.backend.model.Charger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargerRepository extends JpaRepository<Charger, String>{

}
