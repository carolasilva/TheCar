package com.thecar.thecar.repositories;

import com.thecar.thecar.entities.Disponibilidade;
import com.thecar.thecar.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {

}
