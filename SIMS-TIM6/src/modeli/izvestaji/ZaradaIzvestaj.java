package modeli.izvestaji;

import java.util.Date;

public class ZaradaIzvestaj extends Izvestaj {

	private double ukupnaZaradaRSD;
	private double ukupnaZaradaEUR;
	
	public ZaradaIzvestaj(String naziv, Date periodPocetka, Date periodKraja, double ukupnaZaradaRSD,
			double ukupnaZaradaEUR) {
		super(naziv, periodPocetka, periodKraja);
		this.ukupnaZaradaRSD = ukupnaZaradaRSD;
		this.ukupnaZaradaEUR = ukupnaZaradaEUR;
	}

	public double getUkupnaZaradaRSD() {
		return ukupnaZaradaRSD;
	}

	public void setUkupnaZaradaRSD(double ukupnaZaradaRSD) {
		this.ukupnaZaradaRSD = ukupnaZaradaRSD;
	}

	public double getUkupnaZaradaEUR() {
		return ukupnaZaradaEUR;
	}

	public void setUkupnaZaradaEUR(double ukupnaZaradaEUR) {
		this.ukupnaZaradaEUR = ukupnaZaradaEUR;
	}
	
}
