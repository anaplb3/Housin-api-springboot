package com.dcx.pas.housinapi.model;

import java.util.List;
import io.swagger.annotations.ApiModelProperty;

public class House {

  @ApiModelProperty(value = "Código identificador da casa(anúncio)", example = "0")
  private int id;
  @ApiModelProperty(value = "Objeto de endereço da casa", example = "Rua da Alegria, 349, Mamanguape, Centro")
  private HouseAddress endereco;
  @ApiModelProperty(value = "Título do anúncio da casa", example = "Quarto mobíliado individual próximo a universidade")
  private String anuncioHeader;
  //private List<Mobilia> mobilia;
  //private List<User> moradores;

  public House(int id, HouseAddress endereco, String anuncioHeader) {
    this.id = id;
    this.endereco = endereco;
    this.anuncioHeader = anuncioHeader;
  }
  
  public House(){};

  public House(int id, String anuncioHeader){
    this.id = id;
    this.anuncioHeader = anuncioHeader;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public HouseAddress getEndereco() {
    return endereco;
  }

  public void setEndereco(HouseAddress endereco) {
    this.endereco = endereco;
  }

  public String getAnuncioHeader() {
    return anuncioHeader;
  }

  public void setAnuncioHeader(String anuncioHeader) {
    this.anuncioHeader = anuncioHeader;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    House other = (House) obj;
    if (id != other.id)
      return false;
    return true;
  }
}