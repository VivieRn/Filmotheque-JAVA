package fr.eni.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.eni.mvc.bo.Style;
import fr.eni.mvc.service.GestionStyle;

@Controller
public class StyleController {
	@Autowired
	private GestionStyle gs;
	
	//Pour listeStyles.jsp
	@RequestMapping(path = "listerStyle", method = RequestMethod.GET)
	public ModelAndView listerStyle() {
		List<Style> listeS = gs.listeStyles();
		Style style = new Style();
		ModelAndView mav = new ModelAndView("listeStyles", "listeS", listeS);
		mav.getModelMap().addAttribute("style", style);
		return mav;
	}
	
	@RequestMapping(path = "modifStyle", method = RequestMethod.POST)
	public ModelAndView modifStyle(Style s) {
		gs.ajouterOuModifierStyle(s);
		return listerStyle();
	}
	
	@RequestMapping(path = "ajouterStyle", method = RequestMethod.POST)
	public ModelAndView ajouterStyle(@Valid Style style, BindingResult result) {
		if(result.hasErrors()) {
			System.err.println("Erreur de validation");
			List<Style> listeS = gs.listeStyles();
			ModelAndView mav = new ModelAndView("listeStyles", "style", style);
			mav.addObject("listeS", listeS);
			return mav;
		}else {
			gs.ajouterOuModifierStyle(style);
			return listerStyle();
		}
	}
	
	@RequestMapping(path = "supprimerStyle", method = RequestMethod.GET)
	public ModelAndView supprimerStyle(String index) {
		try {
			int i = Integer.parseInt(index);
			Style s = gs.trouverStyle(i);
			gs.supprimerStyle(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listerStyle();
	}
	
	@RequestMapping(path = "trierStyle", method = RequestMethod.GET)
	public ModelAndView trierStyle(String par) {
		List<Style> listeS = gs.trier(par);
		Style style = new Style();
		ModelAndView mav = new ModelAndView("listeStyles", "listeS", listeS);
		mav.getModelMap().addAttribute("style", style);
		return mav;
	}

}
