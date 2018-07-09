package modeli;

import java.util.ArrayList;

import modeli.korisnici.ZaposleniNaNaplatnomMestu;

public class NaplatnoMesto {
	
	private TipNaplatnogMesta tipNaplate;
	private boolean aktivnost;
	private int id;
	
	private NaplatnaStanica naplatnaStanica;
	private KontrolerRampe kontrolerRampe;
	private ZaposleniNaNaplatnomMestu zaposleniNaNaplatnomMestu;
	private ArrayList<Naplata> naplate;
	
	public NaplatnoMesto(TipNaplatnogMesta tipNaplate, int id, NaplatnaStanica naplatnaStanica) {
		super();
		this.tipNaplate = tipNaplate;
		this.id = id;
		this.naplatnaStanica = naplatnaStanica;
		this.kontrolerRampe = new KontrolerRampe();
		this.naplate = new ArrayList<Naplata>();
	}

	public NaplatnoMesto(TipNaplatnogMesta tipNaplate, boolean aktivnost, int id, NaplatnaStanica naplatnaStanica,
			KontrolerRampe kontrolerRampe, ZaposleniNaNaplatnomMestu zaposleniNaNaplatnomMestu,
			ArrayList<Naplata> naplate) {
		super();
		this.tipNaplate = tipNaplate;
		this.aktivnost = aktivnost;
		this.id = id;
		this.naplatnaStanica = naplatnaStanica;
		this.kontrolerRampe = kontrolerRampe;
		this.zaposleniNaNaplatnomMestu = zaposleniNaNaplatnomMestu;
		this.naplate = naplate;
	}

	public TipNaplatnogMesta getTipNaplate() {
		return tipNaplate;
	}

	public void setTipNaplate(TipNaplatnogMesta tipNaplate) {
		this.tipNaplate = tipNaplate;
	}

	public boolean isAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NaplatnaStanica getNaplatnaStanica() {
		return naplatnaStanica;
	}

	public void setNaplatnaStanica(NaplatnaStanica naplatnaStanica) {
		this.naplatnaStanica = naplatnaStanica;
	}

	public KontrolerRampe getKontrolerRampe() {
		return kontrolerRampe;
	}

	public void setKontrolerRampe(KontrolerRampe kontrolerRampe) {
		this.kontrolerRampe = kontrolerRampe;
	}

	public ZaposleniNaNaplatnomMestu getZaposleniNaNaplatnomMestu() {
		return zaposleniNaNaplatnomMestu;
	}

	public void setZaposleniNaNaplatnomMestu(ZaposleniNaNaplatnomMestu zaposleniNaNaplatnomMestu) {
		this.zaposleniNaNaplatnomMestu = zaposleniNaNaplatnomMestu;
	}

	public ArrayList<Naplata> getNaplate() {
		return naplate;
	}

	public void setNaplate(ArrayList<Naplata> naplate) {
		this.naplate = naplate;
	}
	
	public void odabirKategorije() {
		// TODO: implement
	}	
	
	public void odabirMestaPolaska() {
		// TODO: implement
	}
	
	public boolean podizanjeRampe() {
		// TODO: implement
		return false;
	}
	
	public boolean spustanjeRampe() {
		// TODO: implement
		return false;
	}
	
	public void deaktivacijaNaplatnogMesta() {
		// TODO: implement
	}
	
	public Naplata vrsenjeNaplateElektrosnko(Tag tag, double iznos, Deonica deonica) {
		// TODO: implement
		return null;
	}
	
	public Naplata vrsenjeNaplateFizicko(TipValute valuta, double iznos, Kategorija kategorija, Deonica deonica) {
		// TODO: implement
		return null;
	}
	
	public boolean vrsenjeNaplate(double iznos, Deonica deonica) {
		// TODO: implement
		return false;
	}

}
