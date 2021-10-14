package dev.esdras.carros.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 50)
    private String nome;
    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;
    private String descricao;

    public Carro(String nome, String tipo, String descricao) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Carro() {
    }

    public Long getId() {
        return id;
    }

    public Carro setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Carro setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Carro setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Carro setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return id.equals(carro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
