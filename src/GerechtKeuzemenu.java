import java.util.ArrayList;
import java.util.Scanner;

public class GerechtKeuzemenu {
    Scanner scanner = new Scanner(System.in);

    public GerechtKeuzemenu() {
        //TODO GerechtKeuzemenu alleen verantwoordelijk maken voor printen van vragen en antwoorden.
        System.out.println("Waar heeft u trek in? Voer de naam van het type gerecht in\npasta\nrijst\ndeeg\nvegetarisch");
        String gerechtTypeInput = scanner.nextLine();
        gerechtKeuzeKiezen(gerechtTypeInput);
    }

    public void gerechtKeuzeKiezen(String gerechtTypeInput) {// gerechtTypeInput geeft type gerecht aan(Pasta, Rijst, Deeg, Vegetarisch)
        GerechtKeuzemenuOpties gerechtKeuzemenuOpties = new GerechtKeuzemenuOpties();
        Gerecht gerecht = new Gerecht();
        ArrayList<GerechtVerwerker> optiesLijst = gerechtKeuzemenuOpties.getGerechtOptiesLijst(gerechtTypeInput);
        StringBuilder opties = new StringBuilder();
        int teller = 0;
        for (GerechtVerwerker gerechtVerwerker : optiesLijst)
            opties.append(++teller).append(".").append(gerechtVerwerker.getName()).append("\n");
        System.out.println("Waar heeft u trek in? Voer het getal van het gerecht in\n" + opties);
        int gerechtInput = scanner.nextInt();
        System.out.printf("%s%nDit gerecht bevat de volgende ingrediënten%n", optiesLijst.get(gerechtInput - 1));
        for (int i = 0; i < gerecht.zoekGerecht(optiesLijst.get(gerechtInput - 1).getName()).getIngredienten().size(); i++)
            System.out.println(gerecht.zoekGerecht(optiesLijst.get(gerechtInput - 1).getName()).getIngredienten().get(i).getNaam());
        String gekozenGerecht = optiesLijst.get(gerechtInput - 1).getName();
        gerechtInformatie(gekozenGerecht);
    }

    public void gerechtInformatie(String gerecht) {
        GerechtInformatie gerechtInformatie = new GerechtInformatie();
        gerechtInformatie.gerechtSportMaaltijd(gerecht);
        gerechtInformatie.gerechtGezondheid(gerecht);
        gerechtInformatie.voedingswaardesPrinter(gerecht);
    }
}
