package com.dcx.pas.housinapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcx.pas.housinapi.model.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long>{

}
