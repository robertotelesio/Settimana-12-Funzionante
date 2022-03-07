package it.epicode.be.catalogolibri.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.catalogolibri.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	Page<Categoria> findByNomeCategoria(String nome, Pageable pageable);

}


