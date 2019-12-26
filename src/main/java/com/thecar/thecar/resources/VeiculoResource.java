package com.thecar.thecar.resources;

import com.thecar.thecar.entities.Veiculo;
import com.thecar.thecar.entities.enums.Combustivel;
import com.thecar.thecar.entities.enums.Cor;
import com.thecar.thecar.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
  @Autowired
  private VeiculoService veiculoService;

  @GetMapping
  public ResponseEntity<List<Veiculo>> buscarTodos() {
    List<Veiculo> veiculos = veiculoService.buscarTodos();
    return ResponseEntity.ok().body(veiculos);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Veiculo> buscar(@PathVariable Long id) {
    Veiculo veiculo = veiculoService.buscar(id);
    return ResponseEntity.ok().body(veiculo);
  }

  @PostMapping
  public ResponseEntity<Veiculo> inserir(@RequestBody Veiculo veiculo) {
    veiculo = veiculoService.inserir(veiculo);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getId()).toUri();
    return ResponseEntity.created(uri).body(veiculo);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
    veiculo = veiculoService.atualizar(id, veiculo);
    return ResponseEntity.ok().body(veiculo);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    veiculoService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
