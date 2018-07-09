package modeli;

import java.util.Date;

public class Cenovnik {

	private Kategorija kategorija;
	private Date datumVazenja;
	private double cenaRSD;
	private double cenaEUR;
	
	public Cenovnik(Kategorija kategorija, Date datumVazenja, double cenaRSD, double cenaEUR) {
		super();
		this.kategorija = kategorija;
		this.datumVazenja = datumVazenja;
		this.cenaRSD = cenaRSD;
		this.cenaEUR = cenaEUR;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Date getDatumVazenja() {
		return datumVazenja;
	}

	public void setDatumVazenja(Date datumVazenja) {
		this.datumVazenja = datumVazenja;
	}

	public double getCenaRSD() {
		return cenaRSD;
	}

	public void setCenaRSD(double cenaRSD) {
		this.cenaRSD = cenaRSD;
	}

	public double getCenaEUR() {
		return cenaEUR;
	}

	public void setCenaEUR(double cenaEUR) {
		this.cenaEUR = cenaEUR;
	}
	
}
