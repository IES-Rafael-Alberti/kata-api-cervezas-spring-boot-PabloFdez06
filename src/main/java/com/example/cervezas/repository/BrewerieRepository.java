package com.example.cervezas.repository;

import com.example.cervezas.entity.Brewerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrewerieRepository extends JpaRepository<Brewerie, Integer> {

}

