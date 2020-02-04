package com.dcx.pas.housinapi.model;

/**
 * HouseAddress
 */
public class HouseAddress {
  
  private String logradouro;
  private int numero;
  private String cidade;
  private String bairro;
  //private String estado; //

  public HouseAddress(){};
  
  public HouseAddress(String logradouro, int numero, String cidade, String bairro) {
    this.logradouro = logradouro;
    this.numero = numero;
    this.cidade = cidade;
    this.bairro = bairro;
  }
    
  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
}