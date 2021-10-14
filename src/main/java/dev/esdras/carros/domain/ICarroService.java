package dev.esdras.carros.domain;

import dev.esdras.carros.domain.dto.CarroDTO;

import java.util.List;

public interface ICarroService {
    List<CarroDTO> getCarros();
    CarroDTO getCarroById(Long id);
    List<CarroDTO> getCarrosByTipo(String tipo);
    CarroDTO salvar(Carro carro);
}
