package it.epicode.be.catalogolibri.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.catalogolibri.model.Autore;

public interface AutoreRepository extends JpaRepository<Autore, Long>{
	
	List<Autore> findByNome(String nome);
}
	


