package fr.eni.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.mvc.bo.Style;
import fr.eni.mvc.dao.FilmDAO;
import fr.eni.mvc.dao.StyleDAO;

@Service
public class GestionStyle {
	@Autowired
	private StyleDAO sdao;
	
	@Autowired
	private FilmDAO fdao;
	
	public List<Style> listeStyles(){
		return sdao.findAll();
	}
	
	public Style trouverStyle(int id) {
		return sdao.findOne(id);
	}
	
	public void ajouterOuModifierStyle(Style s) {
		boolean exist = sdao.existsByLibelle(s.getLibelle());
		if(!exist) {
			sdao.save(s);
		} 
	}
	
	public void supprimerStyle(Style s) {
		boolean exist = fdao.existsByStyleId(s.getId());
		if(!exist) {
			sdao.delete(s);
		}
	}
	
	public List<Style> trier(String type){
		List<Style> liste = null;
		switch(type) {
		case "iA":
			liste = sdao.findByOrderByIdAsc();
			break;
		case "iD":
			liste = sdao.findByOrderByIdDesc();
			break;
		case "lA":
			liste = sdao.findByOrderByLibelleAsc();
			break;
		case "lD":
			liste = sdao.findByOrderByLibelleDesc();
			break;
		default:
			liste = sdao.findAll();
			break;
		}
		return liste;
	}
}
