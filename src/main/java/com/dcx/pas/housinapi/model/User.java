package com.dcx.pas.housinapi.model;

import io.swagger.annotations.ApiModelProperty;

public class User {

    @ApiModelProperty(value = "Código identificador do usuário", example = "0")
    private int id;

    @ApiModelProperty(value = "Nome do usuário", example = "Ana Paula Lima")
    private String nome;

    @ApiModelProperty(value = "Nome de usuário", example = "anaplb")
    private String login;

    @ApiModelProperty(value = "Senha para o login", example = "aaa234")
    private String senha;

    @ApiModelProperty(value = "Sexo do usuário", example = "feminino")
    private String sexo;

    @ApiModelProperty(value = "Email do usuário", example = "lima.rhcp@gmail.com")
    private String email;

    @ApiModelProperty(value = "Número de telefone do usuário", example = "83991929394")
    private String numeroTelefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
}
