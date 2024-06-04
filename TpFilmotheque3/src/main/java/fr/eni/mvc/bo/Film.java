package fr.eni.mvc.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank
	private String titre;
	
	private int annee;
	
	@ManyToOne
	private Style style;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Realisateur real;
	
	private String duree;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	private List<Acteur> acteurs;
	
	@Lob
	@Column(name = "syno")
	private String synopsis;
	private boolean vu;

	public Film() {
	}

	public Film(String titre, int annee, Style style, Realisateur real, String duree, List<Acteur> acteurs,
			String synopsis, boolean vu) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.style = style;
		this.real = real;
		this.duree = duree;
		this.acteurs = acteurs;
		this.synopsis = synopsis;
		this.vu = vu;
	}

	public Film(int id, String titre, int annee, Style style, Realisateur real, String duree, List<Acteur> acteurs,
			String synopsis, boolean vu) {
		super();
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.style = style;
		this.real = real;
		this.duree = duree;
		this.acteurs = acteurs;
		this.synopsis = synopsis;
		this.vu = vu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Realisateur getReal() {
		return real;
	}

	public void setReal(Realisateur real) {
		this.real = real;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public boolean isVu() {
		return vu;
	}

	public void setVu(boolean vu) {
		this.vu = vu;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", annee=" + annee + ", style=" + style + ", real=" + real
				+ ", duree=" + duree + ", acteurs=" + acteurs + ", synopsis=" + synopsis + ", vu=" + vu + "]";
	}

}
