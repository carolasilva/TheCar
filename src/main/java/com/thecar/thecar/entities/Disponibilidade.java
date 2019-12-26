package com.thecar.thecar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Disponibilidade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private LocalDate dataInicio;
  private LocalDate dataFim;
  private Double valorDaDiaria;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "veiculo_id")
  private Veiculo veiculo;

  public Disponibilidade() {
  }

  public Disponibilidade(Integer id, LocalDate dataInicio, LocalDate dataFim, Double valorDaDiaria, Veiculo veiculo) {
    this.id = id;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.valorDaDiaria = valorDaDiaria;
    this.veiculo = veiculo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(LocalDate dataInicio) {
    this.dataInicio = dataInicio;
  }

  public LocalDate getDataFim() {
    return dataFim;
  }

  public void setDataFim(LocalDate dataFim) {
    this.dataFim = dataFim;
  }

  public Double getValorDaDiaria() {
    return valorDaDiaria;
  }

  public void setValorDaDiaria(Double valorDaDiaria) {
    this.valorDaDiaria = valorDaDiaria;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Disponibilidade that = (Disponibilidade) o;
    return getId().equals(that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
