package com.example.demo.models;

import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;

public class Usuario {

    @Id
    public ObjectId _id;

    public String nome;
    public String email;
    public String senha;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(ObjectId _id, String nome, String email, String senha) {
        this._id = _id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // ObjectId needs to be converted to string
    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
