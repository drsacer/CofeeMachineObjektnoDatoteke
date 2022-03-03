public class Machine {

    int trenutnoStanjeNovca;
    int trenutnoStanjeVode;
    int trenutnoStanjeMlijeka;
    int trenutnoStanjeKave;
    int trenutnoStanjeSalica;

    public Machine(int trenutnoStanjeNovca, int trenutnoStanjeVode, int trenutnoStanjeMlijeka, int trenutnoStanjeKave, int trenutnoStanjeSalica) {
        this.trenutnoStanjeNovca = trenutnoStanjeNovca;
        this.trenutnoStanjeVode = trenutnoStanjeVode;
        this.trenutnoStanjeMlijeka = trenutnoStanjeMlijeka;
        this.trenutnoStanjeKave = trenutnoStanjeKave;
        this.trenutnoStanjeSalica = trenutnoStanjeSalica;
    }

    public int getTrenutnoStanjeNovca() {
        return trenutnoStanjeNovca;
    }

    public void setTrenutnoStanjeNovca(int trenutnoStanjeNovca) {
        this.trenutnoStanjeNovca = trenutnoStanjeNovca;
    }

    public int getTrenutnoStanjeVode() {
        return trenutnoStanjeVode;
    }

    public void setTrenutnoStanjeVode(int trenutnoStanjeVode) {
        this.trenutnoStanjeVode = trenutnoStanjeVode;
    }

    public int getTrenutnoStanjeMlijeka() {
        return trenutnoStanjeMlijeka;
    }

    public void setTrenutnoStanjeMlijeka(int trenutnoStanjeMlijeka) {
        this.trenutnoStanjeMlijeka = trenutnoStanjeMlijeka;
    }

    public int getTrenutnoStanjeKave() {
        return trenutnoStanjeKave;
    }

    public void setTrenutnoStanjeKave(int trenutnoStanjeKave) {
        this.trenutnoStanjeKave = trenutnoStanjeKave;
    }

    public int getTrenutnoStanjeSalica() {
        return trenutnoStanjeSalica;
    }

    public void setTrenutnoStanjeSalica(int trenutnoStanjeSalica) {
        this.trenutnoStanjeSalica = trenutnoStanjeSalica;
    }

    public boolean imaLiDovoljnoResursi (CoffeeCup c){
        if (trenutnoStanjeVode >= c.getPotrebnoVode() && trenutnoStanjeKave >=c.getPotrebnoKave() &&
                trenutnoStanjeMlijeka >= c.getPotrebnoMlijeka() && trenutnoStanjeSalica > 0 ) {
            return true;
        }
        else return false;
    }

    public void napraviKavu (CoffeeCup c) {
        trenutnoStanjeVode-= c.getPotrebnoVode();
        trenutnoStanjeMlijeka-= c.getPotrebnoMlijeka();
        trenutnoStanjeKave-= c.getPotrebnoKave();
        trenutnoStanjeSalica-= 1;
        trenutnoStanjeNovca+=c.getCijena();
    }

    public String provjeriKojiResursFali (CoffeeCup c) {
        String resurs = "";
        if (trenutnoStanjeVode < c.getPotrebnoVode()) resurs = "water";
        else if (trenutnoStanjeMlijeka < c.getPotrebnoMlijeka()) resurs = "milk";
        else if (trenutnoStanjeKave < c.getPotrebnoKave()) resurs = "coffee beans";
        else if (trenutnoStanjeSalica < 1) resurs = "cups";

        return resurs;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "trenutnoStanjeNovca=" + trenutnoStanjeNovca +
                ", trenutnoStanjeVode=" + trenutnoStanjeVode +
                ", trenutnoStanjeMlijeka=" + trenutnoStanjeMlijeka +
                ", trenutnoStanjeKave=" + trenutnoStanjeKave +
                ", trenutnoStanjeSalica=" + trenutnoStanjeSalica +
                '}';
    }
}
