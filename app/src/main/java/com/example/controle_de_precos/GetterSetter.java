package com.example.controle_de_precos;

public class GetterSetter {

    String nome;
    String numero;
    String id;

    public GetterSetter(String nome, String numero, String id) {
        this.nome = nome;
        this.numero = numero;
        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getNumero() {

        return numero;
    }

    public void setNumero(String numero) {

        this.numero = numero;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }
}
