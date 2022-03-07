package it.epicode.be.catalogolibri.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.be.catalogolibri.model.Autore;
import it.epicode.be.catalogolibri.model.Categoria;
import it.epicode.be.catalogolibri.model.Libro;
import it.epicode.be.catalogolibri.repository.AutoreRepository;
import it.epicode.be.catalogolibri.repository.CategoriaRepository;
import it.epicode.be.catalogolibri.repository.LibroRepository;
import it.epicode.be.catalogolibri.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe utility per l'inizializzazione del database all'avvio
 * dell'applicazione
 *
 */
@Component
@Slf4j
public class ApplicationStartupRunner implements CommandLineRunner {

	@Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
    
         List<Categoria> categorie = initCategoria();
            Categoria fantasy = categorie.get(0);
            categoriaRepository.save(fantasy);
            Categoria autobiografia = categorie.get(1);
            categoriaRepository.save(autobiografia);
            List<Categoria> catL1 = new ArrayList<>();    // Lista catagorie libro1
            catL1.add(fantasy);
            List<Categoria> catL2 = new ArrayList<>();    // Lista catagorie libro2
            catL2.add(autobiografia);

            List<Autore> autori = initAutore();
            Autore aut1 = autori.get(0);
            autoreRepository.save(aut1);
            Autore aut2 = autori.get(1);
            autoreRepository.save(aut2);
            List<Autore> auL1 = new ArrayList<>(); //lista autorilibro1
            auL1.add(aut1);
            List<Autore> auL2 = new ArrayList<>(); //lista autorilibro1
            auL2.add(aut2);

            List<Libro> libri = initLibro();
            Libro libro1 = libri.get(0);
            libro1.setCategorie( catL1);
            libro1.setAutori( auL1);

            libroRepository.save(libro1);

            Libro libro2 = libri.get(1);
            libro2.setCategorie( catL2);
            libro2.setAutori(auL2);

            libroRepository.save(libro2);

    }
    
    private List<Autore> initAutore() {
        List<Autore> autori = new ArrayList<>();
        Autore autore1 = new Autore();
        autore1.setNome("Mario");
        autore1.setCognome("Rossi");

        Autore autore2 = new Autore();
        autore2.setNome("Giorgio");
        autore2.setCognome("Verdi");

        autori.add(autore1);
        autori.add(autore2);

        return autori;

    }

    private List<Categoria> initCategoria() {
        List<Categoria> categorie = new ArrayList<>();
        Categoria categoria1 = new Categoria();
        categoria1.setNome("fantasy");

        Categoria categoria2 = new Categoria();
        categoria2.setNome("Autobiografia");

        categorie.add(categoria1);
        categorie.add(categoria2);

        return categorie;

    }

    private List<Libro> initLibro() {
        List<Libro> libri = new ArrayList<>();
        Libro libro = new Libro();
        libro.setTitolo("Le cronache di Narnia");
        libro.setAnnoPubblicazione(1956);
        libro.setPrezzo(10.99);

        Libro libro2 = new Libro();
        libro2.setTitolo("Le nostre verita");
        libro2.setAnnoPubblicazione(2021);
        libro2.setPrezzo(19.00);

        libri.add(libro);
        libri.add(libro2);

        return libri;

    }
    

        }