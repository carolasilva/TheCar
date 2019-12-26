package com.thecar.thecar.services;

import com.thecar.thecar.entities.Veiculo;
import com.thecar.thecar.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
  @Autowired
  private VeiculoRepository veiculoRepository;

  public List<Veiculo> buscarTodos() {
    return veiculoRepository.findAll();
  }

  public Veiculo buscar(Integer id) {
    Optional<Veiculo> obj = veiculoRepository.findById(id);
    return obj.get();
  }
}
