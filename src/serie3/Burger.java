package serie3;

public class Burger extends Bestellung {
    private String patty;

    public Burger(int id, boolean glutenfrei, String sauce, String kaese, String patty){
        super(id, glutenfrei, sauce, kaese);
        this.patty = patty;
    }

    public void setPatty(String patty){
        this.patty=patty;
    }

    public double bestimmeKalorien(){
        double gesamtKalorien = 250;
        gesamtKalorien += super.bestimmeKalorien();
        return gesamtKalorien;
    }

    public String toString(){
        String gf;
        if(super.isGlutenfrei() == true){
            gf = "glutenfreier";
        }
        else {
            gf="";
        }

        return super.toString() + "Burger: " + gf + " Bunboden, " + super.getSauce() + "sauce, "
                + this.patty + "-Patty, " + super.getKaese() + ", Salat, " + "Zwiebel, " + gf + " Bundeckel";
    }

}
