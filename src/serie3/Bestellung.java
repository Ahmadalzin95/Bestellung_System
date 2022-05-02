package serie3;

public class Bestellung {
    private int id;
    private boolean glutenfrei;
    private String sauce;
    private String kaese;

    public Bestellung(int id, boolean glutenfrei, String sauce, String kaese) {
        this.id = id;
        this.glutenfrei = glutenfrei;
        this.sauce = sauce;
        this.kaese = kaese;
    }

    public int getId() {
        return id;
    }

    public boolean isGlutenfrei() {
        return glutenfrei;
    }

    public String getSauce() {
        return sauce;
    }

    public String getKaese() {
        return kaese;
    }

    public void setGlutenfrei(boolean glutenfrei) {

        this.glutenfrei = glutenfrei;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;

    }

    public void setKaese(String kaese) {
        this.kaese = kaese;
    }

    public double bestimmeKalorien() {
        double gesamtKalorien = 150;
        if (kaese.isEmpty() != true) {
            gesamtKalorien += 170;
        }
        if (glutenfrei == true) {
            gesamtKalorien += 25.5;
        }
        return gesamtKalorien;
    }

    public String toString() {

        return "Bestellung " + "(ID =" + getId() + ",kcal = " + bestimmeKalorien() +") ";
    }
}
