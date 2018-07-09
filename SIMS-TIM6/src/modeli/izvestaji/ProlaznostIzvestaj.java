package modeli.izvestaji;

import java.util.Date;

public class ProlaznostIzvestaj extends Izvestaj {
	
	private int ukupnoVozila;

	public ProlaznostIzvestaj(String naziv, Date periodPocetka, Date periodKraja, int ukupnoVozila) {
		super(naziv, periodPocetka, periodKraja);
		this.ukupnoVozila = ukupnoVozila;
	}

	public int getUkupnoVozila() {
		return ukupnoVozila;
	}

	public void setUkupnoVozila(int ukupnoVozila) {
		this.ukupnoVozila = ukupnoVozila;
	}
	
}
