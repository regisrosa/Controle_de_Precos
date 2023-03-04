package com.example.controle_de_precos;

public class Compra {

    private int id;
    private String produto;
    private String estabelecimento;
    private double preco;
    private String data;

    public Compra(){

    }

    public Compra(String produto, String estabelecimento, double preco, String data) {
        this.produto = produto;
        this.estabelecimento = estabelecimento;
        this.preco = preco;
        this.data = data;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "produto='" + produto + '\'' +
                ", estabelecimento='" + estabelecimento + '\'' +
                ", preco=" + preco +
                ", data='" + data + '\'' +
                '}';
    }
}
