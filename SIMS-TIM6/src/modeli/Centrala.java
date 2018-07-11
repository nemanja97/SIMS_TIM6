package modeli;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import modeli.izvestaji.Izvestaj;
import modeli.izvestaji.TipIzvestaja;
import modeli.korisnici.Admin;
import modeli.korisnici.Korisnik;
import modeli.korisnici.SefStanice;
import modeli.korisnici.TipKorisnika;
import modeli.korisnici.ZaposleniNaNaplatnomMestu;
import modeli.korisnici.ZaposleniUCentrali;

public class Centrala {
	
	private static Centrala centrala = null;
	private XStream xstream;
	private Korisnik trenutnoUlogovani;
	private ArrayList<Korisnik> sviKorisnici;
	
	private ArrayList<NaplatnaStanica> naplatneStanice;
	private ArrayList<Deonica> deonice;
	private ArrayList<Izvestaj> izvestaji;
	private ArrayList<Tag> uzetiTagovi;
	
	private Centrala() {
		this.naplatneStanice = new ArrayList<NaplatnaStanica>();
		this.sviKorisnici = new ArrayList<Korisnik>();
		this.deonice = new ArrayList<Deonica>();
		this.izvestaji = new ArrayList<Izvestaj>();
		this.uzetiTagovi = new ArrayList<Tag>();
		this.xstream = new XStream(new StaxDriver());
		
		XStream.setupDefaultSecurity(this.xstream);
		this.xstream.addPermission(AnyTypePermission.ANY);
		this.xstream.setMode(XStream.SINGLE_NODE_XPATH_ABSOLUTE_REFERENCES);
		this.ucitavanjePodataka();
	}
	
	public static Centrala getInstance() {
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
	
	public static Centrala getCentrala() {
		return centrala;
	}

	public static void setCentrala(Centrala centrala) {
		Centrala.centrala = centrala;
	}

	public XStream getXstream() {
		return xstream;
	}

	public void setXstream(XStream xstream) {
		this.xstream = xstream;
	}

	public boolean registracijaDeonice(Mesto m1, Mesto m2, ArrayList<Cenovnik> cenovnici) {
		this.deonice.add(new Deonica(m1, m2, cenovnici));
		return true;
	}
	
	public boolean registracijaStanice(NaplatnaStanica naplatnaStanica) {
		this.naplatneStanice.add(naplatnaStanica);
		return true;
	}
	
	public boolean registracijaKorisnika(String username, String password, TipKorisnika tip) {
		switch (tip) {
			case ADMIN:
				this.sviKorisnici.add(new Admin(username, password));
				return true;
			case SEF_STANICE:
				this.sviKorisnici.add(new SefStanice(username, password));
				return true;
			case ZAPOSLENI_NA_NAPLATNOM_MESTU:
				this.sviKorisnici.add(new ZaposleniNaNaplatnomMestu(username, password));
				return true;
			case ZAPOSLENI_U_CENTRALI:
				this.sviKorisnici.add(new ZaposleniUCentrali(username, password));
				return true;
			default:
				return false;
		}
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
		try {
			this.sviKorisnici = (ArrayList<Korisnik>) this.xstream.fromXML(new FileReader("Korisnici.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.deonice = (ArrayList<Deonica>) this.xstream.fromXML(new FileReader("Deonice.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.naplatneStanice = (ArrayList<NaplatnaStanica>) this.xstream.fromXML(new FileReader("NaplatneStanice.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.izvestaji = (ArrayList<Izvestaj>) this.xstream.fromXML(new FileReader("Izvestaji.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.uzetiTagovi = (ArrayList<Tag>) this.xstream.fromXML(new FileReader("Tagovi.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void snimanjePodataka() {
		String xmlKorisnici = this.xstream.toXML(this.getSviKorisnici());
		String xmlDeonice = this.xstream.toXML(this.getDeonice());
		String xmlNaplatneStanice = this.xstream.toXML(this.getNaplatneStanice());
		String xmlIzvestaji = this.xstream.toXML(this.getIzvestaji());
		String xmlTagovi = this.xstream.toXML(this.getUzetiTagovi());
		BufferedWriter out = null;
		
		try {
			out = new BufferedWriter(new FileWriter("Korisnici.xml"));
			out.write(xmlKorisnici);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			 if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		try {
			out = new BufferedWriter(new FileWriter("Deonice.xml"));
			out.write(xmlDeonice);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			 if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		try {
			out = new BufferedWriter(new FileWriter("NaplatneStanice.xml"));
			out.write(xmlNaplatneStanice);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			 if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		try {
			out = new BufferedWriter(new FileWriter("Izvestaji.xml"));
			out.write(xmlIzvestaji);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			 if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		try {
			out = new BufferedWriter(new FileWriter("Tagovi.xml"));
			out.write(xmlTagovi);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			 if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void logovanje(String username, String password) {
		// TODO: implement
	}
	
	public void odjava() {
		// TODO: implement
	}
}
