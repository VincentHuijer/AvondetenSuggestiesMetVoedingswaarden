import java.util.ArrayList;
import java.util.Random;


class   Gerecht {

    public double prijs;
    public String name;
    public String type;

    //naam van het gerecht, type gerecht(pasta/rijst/etc), prijs van gerecht
    public Gerecht(String name, String type, Double prijs) {
        this.name = name;
        this.prijs = prijs;
        this.type = type;
    }


    /**
     * Geeft een tekst terug met de naam, type en prijs inclusief BTW aan Applicatie
     **/
    public String toString() {

        return String.format("" +
                "U koos voor %s van het type %s. \n" +
                "dit gerecht zou rond de %.2f€ kosten on te bereiden.", getName(), getType(), getPrijs());

    }


    public double getPrijs() {
        return prijs;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


}







