package com.dcx.pas.housinapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcx.pas.housinapi.model.House;

public interface HouseRepository extends JpaRepository<House, Long>{
	House findById(int id);
}
