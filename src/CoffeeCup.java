public class CoffeeCup {

    String ime;
    int potrebnoVode;
    int potrebnoMlijeka;
    int potrebnoKave;
    int cijena;

    public CoffeeCup(String ime, int potrebnoVode, int potrebnoMlijeka, int potrebnoKave,int cijena) {
        this.potrebnoVode = potrebnoVode;
        this.potrebnoMlijeka = potrebnoMlijeka;
        this.potrebnoKave = potrebnoKave;
        this.cijena = cijena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getPotrebnoVode() {
        return potrebnoVode;
    }

    public void setPotrebnoVode(int potrebnoVode) {
        this.potrebnoVode = potrebnoVode;
    }

    public int getPotrebnoMlijeka() {
        return potrebnoMlijeka;
    }

    public void setPotrebnoMlijeka(int potrebnoMlijeka) {
        this.potrebnoMlijeka = potrebnoMlijeka;
    }

    public int getPotrebnoKave() {
        return potrebnoKave;
    }

    public void setPotrebnoKave(int potrebnoKave) {
        this.potrebnoKave = potrebnoKave;
    }

    public int getCijena() {
        return cijena;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }
}
