package fr.eni.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.mvc.bo.Film;

public interface FilmDAO extends JpaRepository<Film, Integer> {
	
	boolean existsByStyleId(int id);

}
