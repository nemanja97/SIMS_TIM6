package modeli;

import modeli.stanja.Spustena;
import modeli.stanja.Stanje;

public class KontrolerRampe {

	private int dozvoljenoVreme;
	private int vremeIzvrsenja;
	private Stanje aktivnoStanje;
	
	public KontrolerRampe() {
		super();
		this.dozvoljenoVreme = 100;
		this.vremeIzvrsenja = 0;
		this.aktivnoStanje = new Spustena();
	}

	public int getDozvoljenoVreme() {
		return dozvoljenoVreme;
	}

	public void setDozvoljenoVreme(int dozvoljenoVreme) {
		this.dozvoljenoVreme = dozvoljenoVreme;
	}

	public int getVremeIzvrsenja() {
		return vremeIzvrsenja;
	}

	public void setVremeIzvrsenja(int vremeIzvrsenja) {
		this.vremeIzvrsenja = vremeIzvrsenja;
	}
	
	public Stanje getAktivnoStanje() {
		return aktivnoStanje;
	}

	public void setAktivnoStanje(Stanje aktivnoStanje) {
		this.aktivnoStanje = aktivnoStanje;
	}
	
	public void promenaStanja(Stanje novoStanje) {
		// TODO: implement
	}
	
	public void ukljuciMotor(SmerMotora smer) {
		// TODO: implement
	}
	
	public void iskljuciMotor() {
		// TODO: implement
	}
	
	public void rampaPodignuta() {
		// TODO: implement	
	}
	
	public void rampaSpustena() {
		// TODO: implement
	}
	
	public void neuspesnoIzvrsavanje() {
		// TODO: implement
	}
	
	public void pritisnutPodizanje() {
		// TODO: implement
	}
	
	public void pritisnutSpustanje() {
		// TODO: implement
	}
	
	public void poslatSignal() {
		// TODO: implement
	}
	
	public void voziloProslo() {
		// TODO: implement
	}
	
	public void predugoTrajanje() {
		// TODO: implement
	}
	
}
