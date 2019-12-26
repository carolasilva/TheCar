package com.thecar.thecar.resources;

import com.thecar.thecar.entities.Veiculo;
import com.thecar.thecar.entities.enums.Combustivel;
import com.thecar.thecar.entities.enums.Cor;
import com.thecar.thecar.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping(value = "{id}")
  public ResponseEntity<Veiculo> buscar(@PathVariable Integer id) {
    Veiculo veiculo = veiculoService.buscar(id);
    return ResponseEntity.ok().body(veiculo);
  }
}
