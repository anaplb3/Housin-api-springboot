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

  public House getHouse(Long id){
    return findHouse(id);
    
  }

  public House findHouse(Long id){
    for(House h: casasCadastradas){
      if(h.getcodigoCasa() == id){
        return h;
      }
    }
    return null;
  }

  public boolean createHouse(House house){
    if(findHouse(house.getcodigoCasa()) == null) {
      return false;
    } else {
    this.casasCadastradas.add(house); 
    return true;
    }
  }

  public boolean deleteHouse(Long id) {
    try {
        this.casasCadastradas.remove(findHouse(id));
        return true;
    } catch (Exception e) {
        return false;
    }
  }

  public boolean updateUser(House house) {
    House houseOld = findHouse(house.getcodigoCasa());
    this.casasCadastradas.remove(houseOld);
    this.casasCadastradas.add(house);
    return true;
  }

}