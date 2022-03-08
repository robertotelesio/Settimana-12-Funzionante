package it.epicode.be.catalogolibri.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	private @NonNull String titolo;
	private @NonNull int annoPubblicazione;
	private @NonNull double prezzo;

	@ManyToMany
	@JoinTable(name = "libro_categorie", joinColumns = @JoinColumn(name = "libro_id"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private List<Categoria> categorie = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "libro_autori", joinColumns = @JoinColumn(name = "autore_id"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private List<Autore> autori = new ArrayList<>();
	
	

	

}
