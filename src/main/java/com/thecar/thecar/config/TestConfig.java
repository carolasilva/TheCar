package com.thecar.thecar.config;

import com.thecar.thecar.entities.Disponibilidade;
import com.thecar.thecar.entities.Veiculo;
import com.thecar.thecar.entities.enums.Combustivel;
import com.thecar.thecar.entities.enums.Cor;
import com.thecar.thecar.repositories.DisponibilidadeRepository;
import com.thecar.thecar.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

  @Autowired
  private VeiculoRepository veiculoRepository;

  @Autowired
  private DisponibilidadeRepository disponibilidadeRepository;

  @Override
  public void run(String... args) throws Exception {
    Veiculo v1 = new Veiculo(null, "MJU0136", "3Rk mh9294 xL X12605", 4, 20000L, "Fibravan", "Buggy Vip 1.8 8V", 2006, Cor.PRATA, Combustivel.GASOLINA);
    Veiculo v2 = new Veiculo(null, "JZP9029", "4Db acPfG7 fz sj6305", 4, 250L, "Wake", "Way 1.6 Total Flex 8V Mec.", 2009, Cor.BRANCO, Combustivel.ETANOL);
    Veiculo v3 = new Veiculo(null, "NAU4189", "1hk AAA6C4 9n fA8111", 4, 23929L, "RAM", "2500 LARAMIE SLT 6.7 TDI  CD 4x4 Diesel", 2012, Cor.PRATA, Combustivel.DIESEL);
    Veiculo v4 = new Veiculo(null, "HOL7641", "74K lmp7At LA Eh0840", 4, 12340L, "TAC", "Stark 2.3 4WD 127cv TDI Diesel 3p", 2010, Cor.MARROM, Combustivel.DIESEL);
    Veiculo v5 = new Veiculo(null, "HWT8753", "10e AA4UaA Yf RP4993", 4, 25320L, "Chrysler", "300 C Touring 5.7 V8 16V 340cv Aut.", 2005, Cor.AMARELO, Combustivel.ETANOL);

    veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5));

    Disponibilidade d1 = new Disponibilidade(null, LocalDate.parse("01/01/2019", formatter), LocalDate.parse("05/01/2019", formatter), 30.0, v1);
    Disponibilidade d2 = new Disponibilidade(null, LocalDate.parse("03/01/2019", formatter), LocalDate.parse("08/01/2019", formatter), 15.0, v2);
    Disponibilidade d3 = new Disponibilidade(null, LocalDate.parse("12/01/2019", formatter), LocalDate.parse("15/02/2019", formatter), 10.0, v2);
    Disponibilidade d4 = new Disponibilidade(null, LocalDate.parse("14/01/2019", formatter), LocalDate.parse("15/01/2019", formatter), 50.0, v3);
    Disponibilidade d5 = new Disponibilidade(null, LocalDate.parse("05/01/2019", formatter), LocalDate.parse("09/01/2019", formatter), 20.0, v4);
    Disponibilidade d6 = new Disponibilidade(null, LocalDate.parse("11/01/2019", formatter), LocalDate.parse("11/02/2019", formatter), 10.0, v4);
    Disponibilidade d7 = new Disponibilidade(null, LocalDate.parse("09/03/2019", formatter), LocalDate.parse("10/03/2019", formatter), 15.0, v4);
    Disponibilidade d8 = new Disponibilidade(null, LocalDate.parse("01/01/2019", formatter), LocalDate.parse("31/01/2019", formatter), 25.0, v5);

    v1.getDisponibilidades().add(d1);
    v2.getDisponibilidades().add(d2);
    v2.getDisponibilidades().add(d3);
    v3.getDisponibilidades().add(d4);
    v4.getDisponibilidades().add(d5);
    v4.getDisponibilidades().add(d6);
    v4.getDisponibilidades().add(d7);
    v5.getDisponibilidades().add(d8);

    veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5));
    disponibilidadeRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8));

  }
}
