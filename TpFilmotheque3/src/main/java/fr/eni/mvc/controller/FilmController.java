package fr.eni.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.mvc.bo.Film;
import fr.eni.mvc.bo.Style;
import fr.eni.mvc.service.GestionFilm;
import fr.eni.mvc.service.GestionStyle;

@Controller
public class FilmController {
	@Autowired
	private GestionFilm gf;
	@Autowired
	private GestionStyle gs;
	
	@RequestMapping(value = "/lister", method = RequestMethod.GET)
	public ModelAndView lister() {
		List<Film> listeF = gf.listeFilm();
		Film film = new Film();
		ModelAndView mav = new ModelAndView("listeFilms", "listeF", listeF);
		mav.getModelMap().addAttribute("film", film);
		return mav;
	}
	
	@RequestMapping(value = "/ajouter", method = RequestMethod.GET)
	public ModelAndView ajouter() {
		List<Style> listeS = gs.listeStyles();
		ModelAndView mav = new ModelAndView("ajouterFilm");
		mav.addObject("film", new Film());
		mav.addObject("listeStyles", listeS);
		return mav;
	}
	
	@RequestMapping(value = "/ajouterValid", method = RequestMethod.POST)
	public ModelAndView ajouterValid(Film f) {
		gf.ajouterFilm(f);
		return lister();
	}
	
	@RequestMapping(value = "/editer", method = RequestMethod.GET)
	public ModelAndView editer(@RequestParam("index") String id) {
		int fid = Integer.parseInt(id.substring(1));
		Film film = gf.trouverFilm(fid);
		List<Style> listeS = gs.listeStyles();
		ModelAndView mav = new ModelAndView("editerFilm");
		mav.addObject("film", film);
		mav.addObject("listeStyles", listeS);
		return mav;
	}
	
	@RequestMapping(value = "/editerValid", method = RequestMethod.POST)
	public ModelAndView editerValid(Film f) {
		gf.ajouterFilm(f);
		return lister();
	}
	
	@RequestMapping(value = "/supprimer", method = RequestMethod.GET)
	public ModelAndView supprimer(@RequestParam("index") String id) {
		int fid = Integer.parseInt(id.substring(1));
		Film film = gf.trouverFilm(fid);
		gf.supprimerFilm(film);
		return lister();
	}
	
	@RequestMapping(value = "/afficher", method = RequestMethod.GET)
	public ModelAndView afficher(@RequestParam("index") String id) {
		List<Style> listeS = gs.listeStyles();
		int fid = Integer.parseInt(id);
		Film film = gf.trouverFilm(fid);
		ModelAndView mav = new ModelAndView("afficherFilm");
		mav.addObject("film", film);
		mav.addObject("listeStyles" ,listeS);
		return mav;
	}
	
	@RequestMapping(value = "/afficher", method = RequestMethod.POST)
	public ModelAndView afficherModifier(Film f) {
		return editerValid(f);
	}

}
