package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Etudiant;

@Repository
public interface IEtudiant extends JpaRepository<Etudiant, Integer> {

}
