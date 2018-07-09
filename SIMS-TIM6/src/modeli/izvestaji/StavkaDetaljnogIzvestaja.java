package modeli.izvestaji;

import modeli.Kategorija;

public class StavkaDetaljnogIzvestaja {

	private Kategorija kat;
	private int ukupnoVozila;
	private double ukupnaZaradaRSD;
	private double ukupnaZaradaEUR;
	
	public StavkaDetaljnogIzvestaja(Kategorija kat, int ukupnoVozila, double ukupnaZaradaRSD, double ukupnaZaradaEUR) {
		super();
		this.kat = kat;
		this.ukupnoVozila = ukupnoVozila;
		this.ukupnaZaradaRSD = ukupnaZaradaRSD;
		this.ukupnaZaradaEUR = ukupnaZaradaEUR;
	}

	public Kategorija getKat() {
		return kat;
	}

	public void setKat(Kategorija kat) {
		this.kat = kat;
	}

	public int getUkupnoVozila() {
		return ukupnoVozila;
	}

	public void setUkupnoVozila(int ukupnoVozila) {
		this.ukupnoVozila = ukupnoVozila;
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
