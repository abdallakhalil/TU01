package Tut01;
import java.util.Arrays;

public class Statistics {

    public static void main(String[] args){
        boolean arrayGueltig = false;
        if(args.length > 0) {                                       //sofern Eingabewerte vorhanden, werden diese,
            arrayGueltig = true;                                    //sofern vom Typ double,im Array givenNumbers gespeichert
            double[] gegebeneZahlen = new double[args.length];      //bei ungültigem Wert wird der Algorithmus nicht ausgeführt
            for(int i = 0; i < args.length; i++) {
                try {
                    gegebeneZahlen[i] = Double.parseDouble(args[i]);
                }
                catch (NumberFormatException e) {
                    System.out.println("Unzulässige Eingabe!");
                    arrayGueltig = false;
                }
            }

            if (arrayGueltig) {

                //Summe(Ausgabe erst nach Ausgabe des Mittelwertes):
                double summe = 0;
                for (int i = 0; i < gegebeneZahlen.length; i++) {
                    summe += gegebeneZahlen[i];
                }

                // Mittelwert:
                double mittelwert = summe/gegebeneZahlen.length;
                System.out.println("Mittelwert: " + mittelwert);

                System.out.println("Summe: " + summe);

                //Varianz(Ausgabe erst nach Ausgabe der Standardabweichung):
                double varianz = 0.0;
                for (int i = 0; i < gegebeneZahlen.length; i++) {
                    varianz += Math.pow((gegebeneZahlen[i] - mittelwert), 2);
                }
                varianz /= (gegebeneZahlen.length - 1);

                //Standardabweichung:
                double standardabweichung = Math.sqrt(varianz);
                System.out.println("Standardabweichung: " + standardabweichung);

                System.out.println("Varianz: " + varianz);

                //Histogramm:
                System.out.println("\nHistogramm:");

                Arrays.sort(gegebeneZahlen);                            //Array wird sortiert, um Zählen zu erleichtern
                double zahlZuZaehlen = gegebeneZahlen[0];
                System.out.print((int)zahlZuZaehlen + ": ");
                for(int i = 0; i < gegebeneZahlen.length; i++) {
                    if(gegebeneZahlen[i] == zahlZuZaehlen) {
                        System.out.print("*");                          //ein * wird für jede Anzahl einer Zahl ausgegeben
                    }
                    else {
                        zahlZuZaehlen = gegebeneZahlen[i];
                        System.out.print("\n" + (int)zahlZuZaehlen + ": *");
                    }
                }
            }
        }
    }
}