package com.dcx.pas.housinapi.controller;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.dcx.pas.housinapi.model.House;
import com.dcx.pas.housinapi.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.*;

/**
 * HouseController
 */
@RestController
@RequestMapping("v1/api/casas")
public class HouseController {

  @Autowired
  private HouseRepository houseRepository;

  @ApiResponse(code = 200, message = "Retorna as casas cadastradas no sistema.")
  @ApiOperation(value = "Retorna as casas cadastradas no sistema.", response = Iterable.class, produces = "application/json")
  @ResponseStatus( HttpStatus.OK )
  public ResponseEntity<?> getHouses(){
    List<House> casas = houseRepository.findAll();
    return !casas.isEmpty() ? ResponseEntity.ok(casas) : ResponseEntity.noContent().build();
  }

  @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Casa encontrada!"),
        @ApiResponse(code = 404, message = "Casa não disponível ou não encontrada.")
  })
  @ApiOperation(value = "Retorna uma casa específica pelo ID", response = House.class, produces = "application/json")
  @GetMapping("/{codigoCasa}")
  public House getHousebyId(@PathVariable(value = "id") Long codigoCasa) {
    return houseRepository.findById(codigoCasa)
      .orElseThrow(() -> new EntityNotFoundException());
  }

  @ApiOperation(value = "Cria uma nova casa", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse( code = 201, message = "Casa cadastrada com sucesso"),
            @ApiResponse( code = 400, message = "Não foi possível criar casa")
  })
  @PostMapping
  public ResponseEntity<House> salvarCasa(@Valid @RequestBody House casa, HttpServletResponse response) {
	  House houseSalva = houseRepository.save(casa);
	  
	  URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigoCasa}")
			  .buildAndExpand(houseSalva.getcodigoCasa()).toUri();
	  response.setHeader("Location", uri.toASCIIString());
	  
	  return ResponseEntity.created(uri).body(houseSalva);
  }

  /*
  @ApiResponses(value = {
    @ApiResponse(code = 400, message = "Não foi possível remover a casa"),
    @ApiResponse(code = 410, message = "Casa removida com sucesso")
  })
  @ApiOperation(value = "Remove uma casa baseada no seu ID")
  @DeleteMapping("/{codigoCasa}")
  public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int id) {
    if (houseRepository.deleteHouse(id)) {
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
  @PutMapping("/{codigoCasa}")
  public ResponseEntity<?> updateUser(@PathVariable(value = "id") int id, @RequestBody House user) {
    if(houseRepository.updateUser(user)) return new ResponseEntity<>(HttpStatus.OK);
    else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
  */

}