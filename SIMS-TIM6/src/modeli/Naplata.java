package modeli;

import java.util.Date;

public class Naplata {
	
	private Kategorija kategorija;
	private double placeniIznos;
	private TipValute valuta;
	private Date vremeProlaska;
	
	public Naplata(Kategorija kategorija, double placeniIznos, TipValute valuta, Date vremeProlaska) {
		super();
		this.kategorija = kategorija;
		this.placeniIznos = placeniIznos;
		this.valuta = valuta;
		this.vremeProlaska = vremeProlaska;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public double getPlaceniIznos() {
		return placeniIznos;
	}

	public void setPlaceniIznos(double placeniIznos) {
		this.placeniIznos = placeniIznos;
	}

	public TipValute getValuta() {
		return valuta;
	}

	public void setValuta(TipValute valuta) {
		this.valuta = valuta;
	}

	public Date getVremeProlaska() {
		return vremeProlaska;
	}

	public void setVremeProlaska(Date vremeProlaska) {
		this.vremeProlaska = vremeProlaska;
	}

}
