package com.dcx.pas.housinapi.controller;

import com.dcx.pas.housinapi.model.House;
import com.dcx.pas.housinapi.service.HouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.*;

/**
 * HouseController
 */
@RestController
public class HouseController {

  @Autowired
  private HouseService houseService;

  @ApiResponse(code = 200, message = "Retorna as casas cadastradas no sistema.")
  @ApiOperation(value = "Retorna as casas cadastradas no sistema.", response = Iterable.class, produces = "application/json")
  @GetMapping("v1/api/casas")
  @ResponseStatus( HttpStatus.OK )
  public ResponseEntity<?> getHouses(){
    return new ResponseEntity<>(houseService.getCasasCadastradas(), HttpStatus.OK);
  }

  @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Casa encontrada!"),
        @ApiResponse(code = 404, message = "Casa não disponível ou não encontrada.")
  })
  @ApiOperation(value = "Retorna uma casa específica pelo ID", response = House.class, produces = "application/json")
  @GetMapping("v1/api/casas/{id}")
  public ResponseEntity<?> getHouse(@PathVariable(value = "id") int id) {
    House house = houseService.getHouse(id);
    if (house != null) return new ResponseEntity<>(house, HttpStatus.OK);
    else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @ApiOperation(value = "Cria uma nova casa", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse( code = 201, message = "Casa cadastrada com sucesso"),
            @ApiResponse( code = 400, message = "Não foi possível criar casa")
  })
  @PostMapping("v1/api/casas")
  public ResponseEntity<?> postUser(@RequestBody House house) {
    if (houseService.createHouse(house)) return new ResponseEntity<>(HttpStatus.CREATED);
    else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @ApiResponses(value = {
    @ApiResponse(code = 400, message = "Não foi possível remover a casa"),
    @ApiResponse(code = 410, message = "Casa removida com sucesso")
  })
  @ApiOperation(value = "Remove uma casa baseada no seu ID")
  @DeleteMapping("v1/api/casas/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int id) {
    if (houseService.deleteHouse(id)) {
      return new ResponseEntity<>(HttpStatus.GONE);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @ApiOperation(value = "Atualiza os dados de uma casa", consumes = "application/json")
  @ApiResponses(value = {
      @ApiResponse( code = 201, message = "Os dados da casa foram atualizados com sucesso"),
      @ApiResponse( code = 400, message = "Não foi possível atualizar os dados da casa")
  })
  @PutMapping("v1/api/casas/{id}")
  public ResponseEntity<?> updateUser(@PathVariable(value = "id") int id, @RequestBody House user) {
    if(houseService.updateUser(user)) return new ResponseEntity<>(HttpStatus.OK);
    else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

}