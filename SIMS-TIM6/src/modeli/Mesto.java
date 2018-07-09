package modeli;

public class Mesto {

	private String naziv;
	private int pttBroj;
	
	public Mesto(String naziv, int pttBroj) {
		super();
		this.naziv = naziv;
		this.pttBroj = pttBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getPttBroj() {
		return pttBroj;
	}

	public void setPttBroj(int pttBroj) {
		this.pttBroj = pttBroj;
	}
	
}
