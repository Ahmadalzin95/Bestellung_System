package serie3;

public class Pizza extends Bestellung {
    private String[] toppings;

    public Pizza(int id, boolean glutenfrei, String sauce, String kaese, String[] toppings) {
        super(id, glutenfrei, sauce, kaese);
        this.toppings = toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public double bestimmeKalorien() {
        double gesamtKalorien = 100 + super.bestimmeKalorien();

        if (toppings[0] != "") {
            gesamtKalorien += (toppings.length * 35);
        }
        return gesamtKalorien;
    }

    public String toString() {
        String sToppings = "";
        for(String i : toppings){
            sToppings += i +", ";
        }
        String gf;
        if(super.isGlutenfrei() == false){
            gf = "glutenfreier";
        }
        else {
            gf="";
        }

        return super.toString() + "Pizza: " + gf + " Boden, " + super.getSauce() + "sauce, " +
                sToppings + super.getKaese();
    }
}
