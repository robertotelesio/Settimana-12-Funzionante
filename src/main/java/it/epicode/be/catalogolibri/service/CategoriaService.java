package it.epicode.be.catalogolibri.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.catalogolibri.common.util.exception.CatalogoException;
import it.epicode.be.catalogolibri.model.Categoria;
import it.epicode.be.catalogolibri.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Optional<Categoria> findById(Long id) {
		return categoriaRepository.findById(id);
	}

	public Page<Categoria> findByNome(String nome, Pageable pageable) {
		return categoriaRepository.findByNomeCategoria(nome, pageable);
	}

	public Page<Categoria> findAll(Pageable pageable) {
		return categoriaRepository.findAll(pageable);
	}

	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Long id, Categoria categoria) {
		Optional<Categoria> categoriaResult = categoriaRepository.findById(id);

		if (categoriaResult.isPresent()) {
			Categoria categoriaUpdate = categoriaResult.get();
			categoriaUpdate.setId(categoria.getId());
			categoriaUpdate.setNome(categoria.getNome());
			categoriaRepository.save(categoriaUpdate);
			return categoriaUpdate;
		} else {
			throw new CatalogoException("Categoria non aggiornata");
		}

	}

	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}

}