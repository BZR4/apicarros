package dev.esdras.carros.domain.dto;

import dev.esdras.carros.domain.Carro;
import org.modelmapper.ModelMapper;

public class CarroDTO {
    private Long id;
    private String nome;
    private String tipo;
    private String descricao;

    public CarroDTO(Long id, String nome, String tipo, String descricao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public CarroDTO() {
    }

    public static CarroDTO create(Carro carro) {
        return new ModelMapper().map(carro, CarroDTO.class);
    }

    public Long getId() {
        return id;
    }

    public CarroDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CarroDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public CarroDTO setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public CarroDTO setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public String toString() {
        return "CarroDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
