package modeli.izvestaji;

import java.util.Date;

import modeli.NaplatnaStanica;
import modeli.NaplatnoMesto;

public class StavkaKvarova {
	
	private Date vremeDesavanja;
	private NaplatnaStanica naplatnaStanica;
	private NaplatnoMesto naplatnoMesto;
	
	public StavkaKvarova(Date vremeDesavanja, NaplatnaStanica naplatnaStanica, NaplatnoMesto naplatnoMesto) {
		super();
		this.vremeDesavanja = vremeDesavanja;
		this.naplatnaStanica = naplatnaStanica;
		this.naplatnoMesto = naplatnoMesto;
	}

	public Date getVremeDesavanja() {
		return vremeDesavanja;
	}

	public void setVremeDesavanja(Date vremeDesavanja) {
		this.vremeDesavanja = vremeDesavanja;
	}

	public NaplatnaStanica getNaplatnaStanica() {
		return naplatnaStanica;
	}

	public void setNaplatnaStanica(NaplatnaStanica naplatnaStanica) {
		this.naplatnaStanica = naplatnaStanica;
	}

	public NaplatnoMesto getNaplatnoMesto() {
		return naplatnoMesto;
	}

	public void setNaplatnoMesto(NaplatnoMesto naplatnoMesto) {
		this.naplatnoMesto = naplatnoMesto;
	}

}
