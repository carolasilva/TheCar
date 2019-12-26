package com.thecar.thecar.entities.enums;

public enum Combustivel {
  GASOLINA(1),
  ETANOL(2),
  DIESEL(3),
  GNV(4);

  private int codigo;

  Combustivel(int codigo) {
    this.codigo = codigo;
  }

  public int getCodigo() {
    return codigo;
  }

  public static Cor valueOf(int codigo) {
    for (Cor cor : Cor.values())
      if (cor.getCodigo() == codigo)
        return cor;

    throw new IllegalArgumentException("Combustível inválido!");
  }
}
