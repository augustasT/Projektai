package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class AplinkaImplementation implements Aplinka {
	private static int gyvuLaivuSkaicius;
	private static int priesininkoLaivuSkaicius;
	private static Laivas[][] lenta = new Laivas[10][10];
	private LaivasImplementation naujasLaivas;
	private boolean galimaStatyti = true;
	private Suvis[][] suviuLentele = new Suvis[10][10];
	private ArrayList<LaivasImplementation> laivuSarasas = new ArrayList<LaivasImplementation>();
	private boolean yraGyvuLaivu = true;

	@Override
	public Laivas padetiLaiva(int dydis, int x, int y, Kryptis kryptis) {

		// tikriname ar aplinkui nera laivu

		for (int i = 0; i < dydis; i++) {
			if ((kryptis == Kryptis.HORIZONTAL && lenta[x][y + i] != null)
					|| (kryptis == Kryptis.VERTICAL && lenta[x + i][y] != null)) {
				galimaStatyti = false;
			}
		}

		if (!galimaStatyti)
			System.out.println("Negalima statyti greta kito laivo!");

		else if (x >= 0 && y >= 0 && dydis > 0 && dydis <= 4 && galimaStatyti
				&& (kryptis == Kryptis.VERTICAL && x + dydis <= 10)
				|| (kryptis == Kryptis.HORIZONTAL && y + dydis <= 10)) {
			naujasLaivas = new LaivasImplementation(dydis);
			laivuSarasas.add(naujasLaivas);

			naujasLaivas.nustatykKoordinatesIrKrypti(x, y, kryptis);
			gyvuLaivuSkaicius++;
			return naujasLaivas;

		} else
			System.out.println("Netinkami parametrai");

		return null;
	}

	@Override
	public int gautiGyvuLaivuSkaiciu() {
		return gyvuLaivuSkaicius;
	}

	@Override
	public int gautiLaivuSkaiciu() {
		return priesininkoLaivuSkaicius;
	}

	@Override
	public Laivas[][] gautiLenta() {

		for (int i = 0; i < naujasLaivas.gautiDydi(); i++) {
			if (naujasLaivas.gaukKrypti() == Kryptis.HORIZONTAL)
				lenta[naujasLaivas.gautiX() + i][naujasLaivas.gautiY()] = naujasLaivas;

			else if (naujasLaivas.gaukKrypti() == Kryptis.VERTICAL)
				lenta[naujasLaivas.gautiX()][naujasLaivas.gautiY() + i] = naujasLaivas;
		}
		sukurkSuviuLentele();

		return lenta;
	}

	@Override
	public boolean sauti(int y, int x) {
		Suvis suvioObjektas = suviuLentele[y][x];

		if (suvioObjektas.gaukLaivoObjekta() != null && !suvioObjektas.arSautas()) {

			suvioObjektas.pasautas(lenta[y][x]);

			// suviuLentele[y][x].gaukX();
			return true;
		} else if (!suvioObjektas.arSautas() && suvioObjektas.gaukLaivoObjekta() == null) {
			suvioObjektas.setSuvisNetaiklus();
			suvioObjektas.sautasTrue();
			return false;
		} else {
			System.out.println("Cia jau buvo sauta!");
			return false;
		}

	}

	public void atspausdinkLenta() {
		System.out.print(" ");
		for (int i = 1; i < 11; i++)
			System.out.print(i + " ");

		System.out.println(" ");
		for (int y = 0; y < suviuLentele.length; y++) {

			System.out.print(y + 1 + " ");
			for (int x = 0; x < suviuLentele[y].length; x++) {

				suviuLentele[x][y].spausdintiBusena();

			}
			System.out.println();
		}
	}

	private void sukurkSuviuLentele() {
		for (int y = 0; y < lenta.length; y++) {
			for (int x = 0; x < lenta[y].length; x++) {

				suviuLentele[y][x] = new Suvis(y, x, lenta[y][x]);

			}
		}
	}

	public boolean patikrinkArYraGyvuLaivu() {
		yraGyvuLaivu = false;

		for (int i = 0; i < laivuSarasas.size(); i++) {
			if (laivuSarasas.get(i).getArGyvas()) {
				yraGyvuLaivu = true;
			}
		}
		if (yraGyvuLaivu)
			return true;
		else {
			System.out.println("PERGALE !");
			return false;
		}
	}

}
