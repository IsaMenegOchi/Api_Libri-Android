package com.cristianomoraes.libri_retorfit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    /** **/
    //Serializa os nomes, ou seja, consigo ler e responder em json
    @SerializedName("cod_usuario")
    //deixa todos os arquivos visualizaveis
    @Expose
    private int cod_usuario;

    @SerializedName("nome")
    //deixa todos os arquivos visualizaveis
    @Expose
     private String nome;

    @SerializedName("sobrenome")
    //deixa todos os arquivos visualizaveis
    @Expose
     private String sobrenome;

    @SerializedName("email")
    //deixa todos os arquivos visualizaveis
    @Expose
     private String email;

    @SerializedName("login")
    //deixa todos os arquivos visualizaveis
    @Expose
     private String login;

    @SerializedName("senha")
    //deixa todos os arquivos visualizaveis
    @Expose
     private String senha;

// CONSTRUTOR VAZIO

    public Usuario() {
    }

    // CONTRUTOR COM COMANDOS

    public Usuario(int cod_usuario, String nome, String sobrenome, String email, String login, String senha) {
        this.cod_usuario = cod_usuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
