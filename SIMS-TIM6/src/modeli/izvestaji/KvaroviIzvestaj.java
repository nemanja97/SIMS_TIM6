package modeli.izvestaji;

import java.util.ArrayList;
import java.util.Date;

public class KvaroviIzvestaj extends Izvestaj {
	
	private ArrayList<StavkaKvarova> stavke;

	public KvaroviIzvestaj(String naziv, Date periodPocetka, Date periodKraja) {
		super(naziv, periodPocetka, periodKraja);
	}

	public KvaroviIzvestaj(String naziv, Date periodPocetka, Date periodKraja, ArrayList<StavkaKvarova> stavke) {
		super(naziv, periodPocetka, periodKraja);
		this.stavke = stavke;
	}

	public ArrayList<StavkaKvarova> getStavke() {
		return stavke;
	}

	public void setStavke(ArrayList<StavkaKvarova> stavke) {
		this.stavke = stavke;
	}
	
}
