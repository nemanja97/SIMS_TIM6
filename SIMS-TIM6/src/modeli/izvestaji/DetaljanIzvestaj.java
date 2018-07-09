package modeli.izvestaji;

import java.util.ArrayList;
import java.util.Date;

public class DetaljanIzvestaj extends Izvestaj {

	private ArrayList<StavkaDetaljnogIzvestaja> stavke;
	
	public DetaljanIzvestaj(String naziv, Date periodPocetka, Date periodKraja) {
		super(naziv, periodPocetka, periodKraja);
		this.stavke = new ArrayList<StavkaDetaljnogIzvestaja>();
	}
	
	public DetaljanIzvestaj(String naziv, Date periodPocetka, Date periodKraja, ArrayList<StavkaDetaljnogIzvestaja> stavke) {
		super(naziv, periodPocetka, periodKraja);
		this.stavke = stavke;
	}

	public ArrayList<StavkaDetaljnogIzvestaja> getStavke() {
		return stavke;
	}

	public void setStavke(ArrayList<StavkaDetaljnogIzvestaja> stavke) {
		this.stavke = stavke;
	}
	
}
