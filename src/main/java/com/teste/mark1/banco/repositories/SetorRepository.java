package com.teste.mark1.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.mark1.banco.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor,Integer> {

}
