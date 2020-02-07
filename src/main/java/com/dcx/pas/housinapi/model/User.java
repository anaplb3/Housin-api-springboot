package com.dcx.pas.housinapi.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class User {

    @ApiModelProperty(value = "Código identificador do usuário", example = "0")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value = "Nome do usuário", example = "Ana Paula Lima")
    @NotNull
    @Size(min = 3, max = 30)
    private String nome;

    @ApiModelProperty(value = "Nome de usuário", example = "anaplb")
    @NotNull
    @Size(min = 3, max = 10)
    private String login;

    @ApiModelProperty(value = "Senha para o login", example = "aaa234")
    @NotNull
    @Size(min = 3, max = 12)
    private String senha;

    @ApiModelProperty(value = "Sexo do usuário", example = "feminino")
    @NotNull
    @Size(min = 1, max = 1)
    private char sexo;

    @ApiModelProperty(value = "Email do usuário", example = "lima.rhcp@gmail.com")
    @NotNull
    private String email;

    @NotNull
    @Size(min = 9, max = 20)
    @ApiModelProperty(value = "Número de telefone do usuário", example = "83991929394")
    private String numeroTelefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
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
