package io.github.guilhermebferreira.myphome;

public class Prato {

    private int imagem;
    private String nome;
    private double nota;

    public Prato(double nota, String nome, int imagem){
        this.imagem = imagem;
        this.nome = nome;
        this.nota = nota;
    }

    public int getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }
}
