package coffeeMainPack;

public class CoffeeProducts {
    // PRODUKTAI

    private int cukrus;
    private int pupeles;
    private int vanduo;
    private int pienas;

    // KONSTRUKTORIUS
    public CoffeeProducts(int cukrus, int pupeles, int vanduo, int pienas) {
        this.cukrus = cukrus;
        this.pupeles = pupeles;
        this.vanduo = vanduo;
        this.pienas = pienas;
    }

    // KURIAMA KOPIJA
    public CoffeeProducts getCopy() {
        return new CoffeeProducts(this.cukrus, this.pupeles, this.vanduo, this.pienas);
    }

    public int getPienas() {
		return pienas;
	}

	public void setPienas(int pienas) {
		this.pienas = pienas;
	}

    public void setCukrus(int cukrus) {
        this.cukrus = cukrus;
    }

    public void setPupeles(int pupeles) {
        this.pupeles = pupeles;
    }

    public void setVanduo(int vanduo) {
        this.vanduo = vanduo;
    }

    public int getCukrus() {
        return cukrus;
    }

    public int getPupeles() {
        return pupeles;
    }

    public int getVanduo() {
        return vanduo;
    }

}
