package modeli;

import java.util.ArrayList;
import java.util.Date;

import modeli.izvestaji.Izvestaj;
import modeli.izvestaji.TipIzvestaja;
import modeli.korisnici.Korisnik;

public class Centrala {
	
	private static Centrala centrala = null;
	private Korisnik trenutnoUlogovani;
	private ArrayList<Korisnik> sviKorisnici;
	
	private ArrayList<NaplatnaStanica> naplatneStanice;
	private ArrayList<Deonica> deonice;
	private ArrayList<Izvestaj> izvestaji;
	private ArrayList<Tag> uzetiTagovi;
	
	private Centrala() {}
	
	private static Centrala getInstance() {
		if (centrala == null)
			centrala = new Centrala();
		return centrala;
	}
	
	public Korisnik getTrenutnoUlogovani() {
		return trenutnoUlogovani;
	}
	
	public void setTrenutnoUlogovani(Korisnik trenutnoUlogovani) {
		this.trenutnoUlogovani = trenutnoUlogovani;
	}
	
	public ArrayList<Korisnik> getSviKorisnici() {
		return sviKorisnici;
	}
	
	public void setSviKorisnici(ArrayList<Korisnik> sviKorisnici) {
		this.sviKorisnici = sviKorisnici;
	}
	
	public ArrayList<NaplatnaStanica> getNaplatneStanice() {
		return naplatneStanice;
	}
	
	public void setNaplatneStanice(ArrayList<NaplatnaStanica> naplatneStanice) {
		this.naplatneStanice = naplatneStanice;
	}
	
	public ArrayList<Deonica> getDeonice() {
		return deonice;
	}
	
	public void setDeonice(ArrayList<Deonica> deonice) {
		this.deonice = deonice;
	}
	
	public ArrayList<Izvestaj> getIzvestaji() {
		return izvestaji;
	}
	
	public void setIzvestaji(ArrayList<Izvestaj> izvestaji) {
		this.izvestaji = izvestaji;
	}
	
	public ArrayList<Tag> getUzetiTagovi() {
		return uzetiTagovi;
	}
	
	public void setUzetiTagovi(ArrayList<Tag> uzetiTagovi) {
		this.uzetiTagovi = uzetiTagovi;
	}
	
	public boolean registracijaDeonice() {
		// TODO: implement
		return false;
	}
	
	public boolean registracijaStanice() {
		// TODO: implement
		return false;
	}
	
	public boolean registracijaKorisnika() {
		// TODO: implement
		return false;
	}
	
	public boolean brisanjeDeonice() {
		// TODO: implement
		return false;
	}
	
	public boolean brisanjeStanice() {
		// TODO: implement
		return false;
	}
	
	public boolean brisanjeKorisnika() {
		// TODO: implement
		return false;
	}
	
	public boolean izmenaDeonice() {
		// TODO: implement
		return false;
	}
	
	public boolean izmenaStanice() {
		// TODO: implement
		return false;
	}
	
	public boolean izmenaKorisnika() {
		// TODO: implement
		return false;
	}
	
	public Izvestaj pravljenjeIzvestaja(TipIzvestaja tip, Date pocetak, Date kraj, ArrayList<NaplatnaStanica> stanice) {
		// TODO: implement
		return null;
	}
	
	public void ucitavanjePodataka() {
		// TODO: implement
	}
	
	public void logovanje(String username, String password) {
		// TODO: implement
	}
	
	public void odjava() {
		// TODO: implement
	}
}
