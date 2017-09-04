package main;

public interface Aplinka {
    /**
     * Metodas skirtas padeti lentoje laiva
     *
     * @param dydis
     * @param x
     * @param y
     * @param kryptis
     * @return null jeigu laivo padÄ—ti nepavyko, kitu atveju - padÄ—to laivo objektas
     */
    Laivas padetiLaiva(int dydis, int x, int y, Kryptis kryptis);

    /**
     * Metodas skirtas suÅ¾inoti kiek laivÅ³ yra prieÅ¡ininko lentoje
     *
     * @return suskaiÄ�iuoti laivai
     */
    int gautiLaivuSkaiciu();

    /**
     * Metodas skirtas suÅ¾inoti dar nenuskandintÅ³ laivÅ³ skaiÄ�iÅ³
     *
     * @return suskaiÄ�iuoti laivai
     */
    int gautiGyvuLaivuSkaiciu();

    /**
     * Metodas grÄ…Å¾ina lentÄ…, kurioje yra sudÄ—lioti laivai.
     *
     * @return dvimatis masyvas imituojantis lentÄ…
     *      1 2 3 4 5 6 7 8 9 10
     *    1 * * * * * * L L L *
     *    2 * L * * * * * * * *
     *    3 * L * * * * * * * *
     *    4 * L * * * * * * * *
     *    5 * L * * * * L * * *
     *    6 * * * * * * L * * *
     *    7 * * L L L * * * * *
     *    8 * * * * * * * * * *
     *    9 * * * * * * L L L L
     *   10 * * * * * * * * * *
     */
    Laivas[][] gautiLenta();

    /**
     * Metodas Å¡auna Ä¯ lentÄ… ir patikrina ar Å¡Å«vis taiklus
     *
     * @param x Å¡Å«vio x koordinatÄ—
     * @param y Å¡Å«vio y koordinatÄ—
     * @return true - taiklus, false - netaiklus
     */
    boolean sauti(int x, int y);
}
