package Tut01;

/**
 * Die Theorie der Funktionsweise vom Sieb des Eratosthenes wurde dem dazugehörigen Wikipedia Artikel
 * entnommen (siehe https://de.wikipedia.org/wiki/Sieb_des_Eratosthenes)
 */
public class Sieve {
    public static void main(String[] args){
        int zahl = Integer.parseInt(args[0]);

        // if-Verzweigung zum abfangen ungültiger Eingaben.
        if(args.length > 1){
            System.out.println("Bitte geben sie nur eine Zahl ein.");
        }
        else if(zahl >= 1){
            sieve(zahl);
        } else{
            System.out.println("Bitte geben Sie einen Wert n > 1 ein.");
        }
    }

    public static void sieve(int n){
        boolean[] istPrim = new boolean[n+1];

        // Alle Werte des Arrays werden auf true gesetzt,
        // um später alle nicht-Primzahlen zu streichen.
        for(int i = 0; i<=n; i++){
            istPrim[i] = true;
        }

        // Äußere Schleife durchläuft alle Zahlen beginnend mit 2.
        // j bleibt aber kleiner oder gleich der Wurzel von n,
        // da min. ein Primfaktor der Zahl nicht größer als Wurzel n sein darf.
        for(int j = 2; j*j <=n; j++) {
            if(istPrim[j]){

                // In der inneren Schleife werden die Vielfachen gestrichen.
                // i startet mit dem Wert j^2, da alle kleineren Werte
                // schon gestrichen sind.
                for(int i = j*j ; i <= n; i += j){
                    istPrim[i] = false;
                }
            }
        }

        // Ausgabe: Ist ein Wert in istPrim[] wahr, dann gebe
        // den Wert seiner Position (i in istPrim[]) aus.
        for(int i = 2; i<=n; i++){
            if(istPrim[i]){
                System.out.print(i + " ");
            }
        }
    }
}
