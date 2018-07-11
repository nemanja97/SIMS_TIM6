package modeli;

import java.util.ArrayList;
import java.util.Date;

import modeli.izvestaji.Izvestaj;
import modeli.izvestaji.TipIzvestaja;
import modeli.korisnici.SefStanice;

public class NaplatnaStanica {
	
	private String naziv;
	
	private SefStanice sefStanice;
	private Centrala centrala;
	private ArrayList<Deonica> deonice;
	private ArrayList<NaplatnoMesto> naplatnaMesta;
	private ArrayList<Izvestaj> izvestaji;
	
	public NaplatnaStanica(String naziv, Centrala centrala, ArrayList<Deonica> deonice,
			ArrayList<NaplatnoMesto> naplatnaMesta) {
		super();
		this.naziv = naziv;
		this.centrala = centrala;
		this.deonice = deonice;
		this.naplatnaMesta = naplatnaMesta;
		this.izvestaji = new ArrayList<Izvestaj>();
	}
	
	public NaplatnaStanica(String naziv, Centrala centrala, ArrayList<Deonica> deonice) {
		super();
		this.naziv = naziv;
		this.centrala = centrala;
		this.deonice = deonice;
		this.naplatnaMesta =  new ArrayList<NaplatnoMesto>();
		this.izvestaji = new ArrayList<Izvestaj>();
	}

	public NaplatnaStanica(String naziv, SefStanice sefStanice, Centrala centrala, ArrayList<Deonica> deonice,
			ArrayList<NaplatnoMesto> naplatnaMesta, ArrayList<Izvestaj> izvestaji) {
		super();
		this.naziv = naziv;
		this.sefStanice = sefStanice;
		this.centrala = centrala;
		this.deonice = deonice;
		this.naplatnaMesta = naplatnaMesta;
		this.izvestaji = izvestaji;
	}
	
	private Object readResolve() {
	    for( NaplatnoMesto child: naplatnaMesta ) {
	      child.setNaplatnaStanica(this);
	    }
	    return this;
	  }

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public SefStanice getSefStanice() {
		return sefStanice;
	}

	public void setSefStanice(SefStanice sefStanice) {
		this.sefStanice = sefStanice;
	}

	public Centrala getCentrala() {
		return centrala;
	}

	public void setCentrala(Centrala centrala) {
		this.centrala = centrala;
	}

	public ArrayList<Deonica> getDeonice() {
		return deonice;
	}

	public void setDeonice(ArrayList<Deonica> deonice) {
		this.deonice = deonice;
	}

	public ArrayList<NaplatnoMesto> getNaplatnaMesta() {
		return naplatnaMesta;
	}

	public void setNaplatnaMesta(ArrayList<NaplatnoMesto> naplatnaMesta) {
		this.naplatnaMesta = naplatnaMesta;
	}

	public ArrayList<Izvestaj> getIzvestaji() {
		return izvestaji;
	}

	public void setIzvestaji(ArrayList<Izvestaj> izvestaji) {
		this.izvestaji = izvestaji;
	}
	
	public void prijavaKvara() {
		// TODO: implement
	}
	
	public Izvestaj pravljenjeIzvestaja(TipIzvestaja tip, Date pocetak, Date kraj) {
		// TODO: implement
		return null;
	}
	
	public void izmenaCena() {
		// TODO: implement
	}

}
