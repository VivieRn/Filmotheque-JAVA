package fr.eni.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.mvc.bo.Film;
import fr.eni.mvc.dao.FilmDAO;

@Service
public class GestionFilm {
	@Autowired
	private FilmDAO fdao;
	
	public List<Film> listeFilm(){
		return fdao.findAll();
	}
	
	public Film trouverFilm(int id) {
		return fdao.findOne(id);
	}
	
	public void ajouterFilm(Film f) {
		fdao.save(f);
	}
	
	public void modifierFilm(Film f) {
		fdao.save(f);
	}
	
	public void supprimerFilm(Film f) {
		fdao.delete(f);
	}
}
