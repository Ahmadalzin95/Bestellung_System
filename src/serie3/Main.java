package serie3;

public class Main {

  public static Bestellung[] generiereBestellung(String [][] initialeBestellungen){

      Bestellung[] bestellung = new Bestellung[initialeBestellungen.length];

      for (int i = 0; i < initialeBestellungen.length; i++){

          if(initialeBestellungen[i][1] == "Burger"){
              bestellung[i] = new Burger (Integer.parseInt(initialeBestellungen[i][0]),Boolean.parseBoolean(initialeBestellungen[i][3]),
                      initialeBestellungen[i][2], initialeBestellungen[i][4], initialeBestellungen[i][5]);
          }
          else if (initialeBestellungen[i][1] == "Pizza"){

              bestellung[i] = new Pizza (Integer.parseInt(initialeBestellungen[i][0]),Boolean.parseBoolean(initialeBestellungen[i][3]),
                      initialeBestellungen[i][2], initialeBestellungen[i][4], initialeBestellungen[i][5].split(","));

          }
      }
      return bestellung;
   }

     public static void aktualisiereBestellungen(String [][] aktualisiereBestellungen, Bestellung [] bestellungen){

      for (int i = 0; i < aktualisiereBestellungen.length; i++){
          for (int j =0; j < bestellungen.length; j++) {
              if (Integer.parseInt(aktualisiereBestellungen[i][0]) == bestellungen[j].getId()) {
                  bestellungen[j].setSauce(aktualisiereBestellungen[i][1]);
                  bestellungen[j].setGlutenfrei(Boolean.parseBoolean(aktualisiereBestellungen[i][2]));
                  bestellungen[j].setKaese(aktualisiereBestellungen[i][3]);

                  if (bestellungen[j] instanceof Burger) {
                      ((Burger) bestellungen[j]).setPatty (aktualisiereBestellungen[i][4]);
                  }
                  if (bestellungen[j] instanceof Pizza) {
                      ((Pizza)bestellungen[j]).setToppings (aktualisiereBestellungen[i][4].split(","));
                  }
              }
          }
      }
    }

    public static void main(String [] args) {

      Bestellung[] bestellung;

      bestellung = generiereBestellung(new String[][]{  {"0","Burger","Curry","true","Cheddar","Rindfleisch"},
                                                        {"1","Burger","Aioli","false","","Vegan"},
                                                        {"3","Pizza","Barbecue","false","Mozzarella","Salami,Mais,Chili"},
                                                        {"7","Pizza","Tomaten","false","Mozzarella",""}});

        System.out.println("Generiere Bestellung:");
      for (Bestellung i : bestellung) {
            System.out.println(i);
        }

      aktualisiereBestellungen(new String[][]{  {"0","Aioli","true","","Hähnchen"},
                                                {"7","Tomaten","true","Mozzarella",""}}, bestellung);

        System.out.println("Aktualisiere Bestellungen:");
      for (Bestellung i : bestellung){
          System.out.println(i);
     }

  }
}
