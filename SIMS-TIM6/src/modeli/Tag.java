package modeli;

public class Tag {
	
	private double iznos;
	private String brojTablica;
	private Kategorija kat;
	
	public Tag(double iznos, String brojTablica, Kategorija kat) {
		super();
		this.iznos = iznos;
		this.brojTablica = brojTablica;
		this.kat = kat;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public String getBrojTablica() {
		return brojTablica;
	}

	public void setBrojTablica(String brojTablica) {
		this.brojTablica = brojTablica;
	}

	public Kategorija getKat() {
		return kat;
	}

	public void setKat(Kategorija kat) {
		this.kat = kat;
	}

}
