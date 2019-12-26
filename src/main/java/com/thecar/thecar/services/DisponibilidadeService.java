package com.thecar.thecar.services;

import com.thecar.thecar.entities.Disponibilidade;
import com.thecar.thecar.entities.Veiculo;
import com.thecar.thecar.repositories.DisponibilidadeRepository;
import com.thecar.thecar.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisponibilidadeService {
  @Autowired
  private DisponibilidadeRepository disponibilidadeRepository;

  public List<Disponibilidade> buscarTodos() {
    return disponibilidadeRepository.findAll();
  }

  public Disponibilidade buscar(Long id) {
    Optional<Disponibilidade> obj = disponibilidadeRepository.findById(id);
    return obj.get(); //TODO tratamento de exceção
  }

  public Disponibilidade inserir(Disponibilidade disponibilidade) {
    return disponibilidadeRepository.save(disponibilidade);
  }

  public void deletar(Long id) {
    disponibilidadeRepository.deleteById(id); //TODO tratamento de exceção
  }

  public Disponibilidade atualizar (Long id, Disponibilidade disponibilidade) {
    Disponibilidade entity = disponibilidadeRepository.getOne(id);
    atualizarDiponibilidade(entity, disponibilidade);
    return disponibilidadeRepository.save(entity);
  }

  private void atualizarDiponibilidade(Disponibilidade entity, Disponibilidade disponibilidade) {
    entity.setDataFim(disponibilidade.getDataFim());
    entity.setDataInicio((disponibilidade.getDataInicio()));
    entity.setValorDaDiaria(disponibilidade.getValorDaDiaria());
  }
}
