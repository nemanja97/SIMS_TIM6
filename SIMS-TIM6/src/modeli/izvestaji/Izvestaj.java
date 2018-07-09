package modeli.izvestaji;

import java.util.Date;

public abstract class Izvestaj {

	private String naziv;
	private Date periodPocetka;
	private Date periodKraja;
	
	public Izvestaj(String naziv, Date periodPocetka, Date periodKraja) {
		super();
		this.naziv = naziv;
		this.periodPocetka = periodPocetka;
		this.periodKraja = periodKraja;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getPeriodPocetka() {
		return periodPocetka;
	}

	public void setPeriodPocetka(Date periodPocetka) {
		this.periodPocetka = periodPocetka;
	}

	public Date getPeriodKraja() {
		return periodKraja;
	}

	public void setPeriodKraja(Date periodKraja) {
		this.periodKraja = periodKraja;
	}
	
}
