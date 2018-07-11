package modeli;

import java.util.ArrayList;

public class Deonica {
	

	private Mesto mesto1;
	private Mesto mesto2;
	private ArrayList<Cenovnik> cenovnici;
	
	public Deonica(Mesto mesto1, Mesto mesto2, Cenovnik c) {
		super();
		this.mesto1 = mesto1;
		this.mesto2 = mesto2;
		this.cenovnici = new ArrayList<Cenovnik>();
		this.cenovnici.add(c);
	}

	public Deonica(Mesto mesto1, Mesto mesto2) {
		super();
		this.mesto1 = mesto1;
		this.mesto2 = mesto2;
		this.cenovnici = new ArrayList<Cenovnik>();
	}
	
	public Deonica(Mesto mesto1, Mesto mesto2, ArrayList<Cenovnik> cenovnici) {
		super();
		this.mesto1 = mesto1;
		this.mesto2 = mesto2;
		this.cenovnici = cenovnici;
	}

	public Mesto getMesto1() {
		return mesto1;
	}

	public void setMesto1(Mesto mesto1) {
		this.mesto1 = mesto1;
	}

	public Mesto getMesto2() {
		return mesto2;
	}

	public void setMesto2(Mesto mesto2) {
		this.mesto2 = mesto2;
	}

	public ArrayList<Cenovnik> getCenovnici() {
		return cenovnici;
	}

	public void setCenovnici(ArrayList<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}
	
}
