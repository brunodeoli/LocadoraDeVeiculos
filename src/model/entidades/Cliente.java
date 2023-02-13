package model.entidades;

import model.enums.TipoDeCliente;
import model.tipos.Contato;

public class Cliente implements Entidade{

    private static final long serialVersionUID = 1L;

    private final String nome;
    private final String id;
    private final TipoDeCliente tipoDeCliente;
    private Contato contato;

    public Cliente(String nome, String id, TipoDeCliente tipoDeCliente, Contato contato) {
        this.nome = nome;
        this.id = id;
        this.tipoDeCliente = tipoDeCliente;
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

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
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
