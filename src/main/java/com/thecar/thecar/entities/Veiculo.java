package com.thecar.thecar.entities;

import com.thecar.thecar.entities.enums.Combustivel;
import com.thecar.thecar.entities.enums.Cor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Veiculo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String placa;
  private String chassi;
  private Integer numeroDePortas;
  private Long quilometragem;
  private String marca;
  private String modelo;
  private int ano;
  private Cor cor;
  private Combustivel combustivel;

  @OneToMany(mappedBy = "veiculo")
  private List<Disponibilidade> disponibilidades = new ArrayList<>();

  public Veiculo() {
  }

  public Veiculo(Long id, String placa, String chassi, Integer numeroDePortas, Long quilometragem, String marca, String modelo, int ano, Cor cor, Combustivel combustivel) {
    this.id = id;
    this.placa = placa;
    this.chassi = chassi;
    this.numeroDePortas = numeroDePortas;
    this.quilometragem = quilometragem;
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.cor = cor;
    this.combustivel = combustivel;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getChassi() {
    return chassi;
  }

  public void setChassi(String chassi) {
    this.chassi = chassi;
  }

  public Integer getNumeroDePortas() {
    return numeroDePortas;
  }

  public void setNumeroDePortas(Integer numeroDePortas) {
    this.numeroDePortas = numeroDePortas;
  }

  public Long getQuilometragem() {
    return quilometragem;
  }

  public void setQuilometragem(Long quilometragem) {
    this.quilometragem = quilometragem;
  }

  public Cor getCor() {
    return cor;
  }

  public void setCor(Cor cor) {
    this.cor = cor;
  }

  public Combustivel getCombustivel() {
    return combustivel;
  }

  public void setCombustivel(Combustivel combustivel) {
    this.combustivel = combustivel;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public List<Disponibilidade> getDisponibilidades() {
    return disponibilidades;
  }

  public void setDisponibilidades(List<Disponibilidade> disponibilidades) {
    this.disponibilidades = disponibilidades;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Veiculo veiculo = (Veiculo) o;
    return getId().equals(veiculo.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
