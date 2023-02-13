package model.entidades;

import model.tipos.Contato;

public class Cliente implements Entidade{

    private static final long serialVersionUID = 1L;

    public final String nome;
    public final String id;
    public Contato contato;

    public Cliente(String nome, String id, Contato contato) {
        this.nome = nome;
        this.id = id;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", " + id;
    }
}
