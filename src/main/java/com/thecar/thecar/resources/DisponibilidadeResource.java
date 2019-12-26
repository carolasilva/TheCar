package com.thecar.thecar.resources;

import com.thecar.thecar.entities.Disponibilidade;
import com.thecar.thecar.entities.Disponibilidade;
import com.thecar.thecar.services.DisponibilidadeService;
import com.thecar.thecar.services.DisponibilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/disponibilidades")
public class DisponibilidadeResource {
  @Autowired
  private DisponibilidadeService disponibilidadeService;

  @GetMapping
  public ResponseEntity<List<Disponibilidade>> buscarTodos() {
    List<Disponibilidade> disponibilidades = disponibilidadeService.buscarTodos();
    return ResponseEntity.ok().body(disponibilidades);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Disponibilidade> buscar(@PathVariable Long id) {
    Disponibilidade disponibilidade = disponibilidadeService.buscar(id);
    return ResponseEntity.ok().body(disponibilidade);
  }

  @PostMapping
  public ResponseEntity<Disponibilidade> inserir(@RequestBody Disponibilidade disponibilidade) {
    disponibilidade = disponibilidadeService.inserir(disponibilidade);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disponibilidade.getId()).toUri();
    return ResponseEntity.created(uri).body(disponibilidade);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Disponibilidade> atualizar(@PathVariable Long id, @RequestBody Disponibilidade disponibilidade) {
    disponibilidade = disponibilidadeService.atualizar(id, disponibilidade);
    return ResponseEntity.ok().body(disponibilidade);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    disponibilidadeService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
