package it.epicode.be.catalogolibri.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.catalogolibri.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> { 


	List<Libro> findByTitolo(String titolo);
    List<Libro> findByAutoriCognome(String cognome);
    List<Libro> findByCategorieNome(String categoria);

}
