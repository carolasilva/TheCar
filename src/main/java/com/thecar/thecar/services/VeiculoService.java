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

  public Veiculo buscar(Long id) {
    Optional<Veiculo> obj = veiculoRepository.findById(id);
    return obj.get(); //TODO tratamento de exceção
  }

  public Veiculo inserir(Veiculo veiculo) {
    return veiculoRepository.save(veiculo);
  }

  public void deletar(Long id) {
    veiculoRepository.deleteById(id); //TODO tratamento de exceção
  }

  public Veiculo atualizar (Long id, Veiculo veiculo) {
    Veiculo entity = veiculoRepository.getOne(id);
    atualizarVeiculo(entity, veiculo);
    return veiculoRepository.save(entity);
  }

  private void atualizarVeiculo(Veiculo entity, Veiculo veiculo) {
    entity.setAno(veiculo.getAno());
    entity.setChassi(veiculo.getChassi());
    entity.setCombustivel(veiculo.getCombustivel());
    entity.setCor(veiculo.getCor());
    entity.setMarca(veiculo.getMarca());
    entity.setModelo(veiculo.getModelo());
    entity.setNumeroDePortas(veiculo.getNumeroDePortas());
    entity.setPlaca(veiculo.getPlaca());
    entity.setQuilometragem(veiculo.getQuilometragem());
  }
}
