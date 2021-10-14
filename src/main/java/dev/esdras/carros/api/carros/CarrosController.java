package dev.esdras.carros.api.carros;

import dev.esdras.carros.domain.Carro;
import dev.esdras.carros.domain.CarroService;
import dev.esdras.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> getAll() {
        List<CarroDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Long id) {
        CarroDTO carro = service.getCarroById(id);
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<CarroDTO>> findByTipo(@PathVariable String tipo) {
        List<CarroDTO> carrosPorTipo = service.getCarrosByTipo(tipo);
        if (carrosPorTipo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrosPorTipo);
    }

    @PostMapping
    public ResponseEntity<CarroDTO> save(@Valid @RequestBody Carro carro) {
        CarroDTO carroDTO = service.salvar(carro);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carroDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
