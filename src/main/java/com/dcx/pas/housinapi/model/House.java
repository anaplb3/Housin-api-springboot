package com.dcx.pas.housinapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity 
@Table(name="casa")
public class House implements Serializable{
	
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "Código identificador da casa(anúncio)", example = "0")
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long codigoCasa;
  
  @ApiModelProperty(value = "Objeto de endereço da casa", example = "Rua da Alegria, 349, Mamanguape, Centro")
  private HouseAddress endereco;
  
  @ApiModelProperty(value = "Título do anúncio da casa", example = "Quarto mobíliado individual próximo a universidade")
  private String anuncioHeader;
  
  //private List<Mobilia> mobilia;
  //private List<User> moradores;

  public House(Long codigoCasa, HouseAddress endereco, String anuncioHeader) {
    this.codigoCasa = codigoCasa;
    this.endereco = endereco;
    this.anuncioHeader = anuncioHeader;
  }
  
  public House(){};

  public House(Long codigoCasa, String anuncioHeader){
    this.codigoCasa = codigoCasa;
    this.anuncioHeader = anuncioHeader;
  }
  
  public Long getcodigoCasa() {
    return this.codigoCasa;
  }

  public void setcodigoCasa(Long codigoCasa) {
    this.codigoCasa = codigoCasa;
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
    if (codigoCasa != other.codigoCasa)
      return false;
    return true;
  }
}