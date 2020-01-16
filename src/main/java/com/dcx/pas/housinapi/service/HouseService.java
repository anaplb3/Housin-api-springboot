package com.dcx.pas.housinapi.service;

import java.util.List;
import com.dcx.pas.housinapi.model.House;
import org.springframework.stereotype.Service;

/**
 * HouseService
 */
@Service
public class HouseService {

  public List<House> casasCadastradas;

  
  public List<House> getCasasCadastradas() {
    return this.casasCadastradas;
  }

  public House getHouse(int id){
    return findHouse(id);
    
  }

  public House findHouse(int id){
    for(House h: casasCadastradas){
      if(h.getId() == id){
        return h;
      }
    }
    return null;
  }

  public boolean createHouse(House house){
    if(findHouse(house.getId()) == null) {
      return false;
    } else {
    this.casasCadastradas.add(house); 
    return true;
    }
  }

  public boolean deleteHouse(int id) {
    try {
        this.casasCadastradas.remove(findHouse(id));
        return true;
    } catch (Exception e) {
        return false;
    }
  }

  public boolean updateUser(House house) {
    House houseOld = findHouse(house.getId());
    this.casasCadastradas.remove(houseOld);
    this.casasCadastradas.add(house);
    return true;
  }

}