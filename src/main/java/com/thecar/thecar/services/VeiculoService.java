package com.thecar.thecar.services;

import com.thecar.thecar.entities.Veiculo;
import com.thecar.thecar.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
  @Autowired
  private VeiculoRepository veiculoRepository;

  public List<Veiculo> findAll() {
    return veiculoRepository.findAll();
  }
}
