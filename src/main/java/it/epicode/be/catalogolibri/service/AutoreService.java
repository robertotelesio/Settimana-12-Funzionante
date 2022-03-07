package it.epicode.be.catalogolibri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.catalogolibri.common.util.exception.CatalogoException;
import it.epicode.be.catalogolibri.model.Autore;
import it.epicode.be.catalogolibri.model.Libro;
import it.epicode.be.catalogolibri.repository.AutoreRepository;
import it.epicode.be.catalogolibri.repository.LibroRepository;

@Service
public class AutoreService {

	@Autowired
	AutoreRepository autoreRepository;


    @Autowired
    LibroRepository libroRepository;

    public Optional<Autore> findById( Long id) {
        return autoreRepository.findById(id);
    }

    public List<Autore> findByNome(String nome) {
        return autoreRepository.findByNome(nome);
    }

    public List<Autore> findAll() {
        return autoreRepository.findAll();
    }

    public Autore save(Autore autore) {
        return autoreRepository.save(autore);
    }

    public Autore update(Long id, Autore autore) {
        Optional<Autore> autoreResult = autoreRepository.findById(id);

        if (autoreResult.isPresent()) {
            Autore autoreUpdate = autoreResult.get();
            autoreUpdate.setNome(autore.getNome());
            autoreUpdate.setCognome(autore.getCognome());
            autoreRepository.save(autoreUpdate);
            return autoreUpdate;
        } else {
            throw new CatalogoException("Autore non aggiornato");
        }

    }

    public void delete(Long id) {
        Autore a = autoreRepository.findById(id).get();
        List<Libro> listalibri = libroRepository.findByAutoriCognome(a.getCognome());
        for(Libro libro : listalibri) {
            libro.getAutori().remove(a);
            libroRepository.save(libro);
        }
        autoreRepository.deleteById(id);
    }
}