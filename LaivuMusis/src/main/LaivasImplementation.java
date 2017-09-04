package main;

/* 4x1
 * 3x2
 * 2x3
 * 1x4*/

public class LaivasImplementation implements Laivas {
	private int dydis;
	private int x;
	private int y;
	private Kryptis kryptis;
	private int kiekKartuPasautas;
	private boolean arGyvas = true;

	public LaivasImplementation(int dydis) {
		this.dydis = dydis;

	}

	public void nustatykKoordinatesIrKrypti(int x, int y, Kryptis kryptis) {
		this.x = x;
		this.y = y;
		this.kryptis = kryptis;
	}

	public int gautiDydi() {
		return dydis;
	}

	@Override
	public int gautiX() {

		return x;
	}

	@Override
	public int gautiY() {
		return y;
	}

	public Kryptis gaukKrypti() {
		return kryptis;
	}
	public void pasautas() {
		kiekKartuPasautas++;
		patikrinkArGyvas();		
	}
	private void patikrinkArGyvas() {
		if(kiekKartuPasautas == dydis)
			arGyvas = false;
	}
	public boolean getArGyvas() {
		return arGyvas;
	}
}
