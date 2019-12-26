package com.thecar.thecar.config;

import com.thecar.thecar.entities.Veiculo;
import com.thecar.thecar.entities.enums.Combustivel;
import com.thecar.thecar.entities.enums.Cor;
import com.thecar.thecar.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  @Autowired
  private VeiculoRepository veiculoRepository;

  @Override
  public void run(String... args) throws Exception {
    Veiculo v1 = new Veiculo(1, "MJU0136", "3Rk mh9294 xL X12605", 4, 20000L, "Fibravan", "Buggy Vip 1.8 8V", 2006, Cor.PRATA, Combustivel.GASOLINA);
    Veiculo v2 = new Veiculo(2, "JZP9029", "4Db acPfG7 fz sj6305", 4, 250L, "Wake", "Way 1.6 Total Flex 8V Mec.", 2009, Cor.BRANCO, Combustivel.ETANOL);
    Veiculo v3 = new Veiculo(3, "NAU4189", "1hk AAA6C4 9n fA8111", 4, 23929L, "RAM", "2500 LARAMIE SLT 6.7 TDI  CD 4x4 Diesel", 2012, Cor.PRATA, Combustivel.DIESEL);
    Veiculo v4 = new Veiculo(4, "HOL7641", "74K lmp7At LA Eh0840", 4, 12340L, "TAC", "Stark 2.3 4WD 127cv TDI Diesel 3p", 2010, Cor.MARROM, Combustivel.DIESEL);
    Veiculo v5 = new Veiculo(5, "HWT8753", "10e AA4UaA Yf RP4993", 4, 25320L, "Chrysler", "300 C Touring 5.7 V8 16V 340cv Aut.", 2005, Cor.AMARELO, Combustivel.ETANOL);

    veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5));
  }
}
