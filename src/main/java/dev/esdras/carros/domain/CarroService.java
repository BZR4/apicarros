package dev.esdras.carros.domain;

import dev.esdras.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService implements ICarroService {

    @Autowired
    private CarroRepository repository;

    @Override
    public List<CarroDTO> getCarros() {
        return repository.findAll()
                .stream()
                .map(CarroDTO::create)
                .collect(Collectors.toList());
    }

    @Override
    public CarroDTO getCarroById(Long id) {
        Optional<Carro> optionalCarro = repository.findById(id);
        //TODO: Criar exceção customizada...
        return optionalCarro.map(CarroDTO::create).orElse(new CarroDTO());
    }

    @Override
    public List<CarroDTO> getCarrosByTipo(String tipo) {
        return repository.findByTipo(tipo)
                .stream()
                .map(CarroDTO::create)
                .collect(Collectors.toList());
    }

    @Override
    public CarroDTO salvar(Carro carro) {
        Carro save = repository.save(carro);
        return CarroDTO.create(save);
    }
}
