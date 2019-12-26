package com.thecar.thecar.entities.enums;

public enum Cor {
  PRETO(1),
  PRATA(2),
  VERMELHO(3),
  BRANCO(4),
  AMARELO(5),
  DOURADO(6),
  VERDE(7),
  AZUL(8),
  ROXO(9),
  CINZA(10),
  ROSA(11),
  MARROM(12);

  private int codigo;

  Cor(int codigo) {
    this.codigo = codigo;
  }


  public int getCodigo() {
    return codigo;
  }

  public static Cor valueOf(int codigo) {
    for (Cor cor : Cor.values())
      if (cor.getCodigo() == codigo)
        return cor;

    throw new IllegalArgumentException("Cor inválida!");
  }
}
