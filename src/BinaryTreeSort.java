/**
 * Alle werte des Arrays werden in einem binärer Baum gespeichert. Dieser Baum besteht aus Knoten mit je 2 Unterknoten.
 * Jeder dieser Knoten haben einen Wert. Falls der neu eingetragener Wert grösser ist als der Knoten wird zum Unterknoten
 * rechts gegangen. Sonst wir der Unteknoten links verwendet. Und das selbe immer weiter bis ein Knoten gefunden
 * wird wo noch keinen Wert besitzt.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class BinaryTreeSort extends SortAttributes{
    /**
     * Das ist der Counter um die Datenstruktur wieder zu einem Array zu wandeln
     */
    private int index;

    /**
     * Das ist die Klasse, in der die Daten des Arrays gespeichert werden
     */
    private class Knoten{
        int wert;
        Knoten linkerKnoten,rechterKnoten;

        private Knoten(int wert) {
            this.wert = wert;
            speicherbedarf+=32;
        }
    }

    @Override
    public void sort(int[] zahlen) {
        resetAttributes();
        index=0;
        long start = System.currentTimeMillis();

        array=zahlen;
        binaryTreeSort();

        long end = System.currentTimeMillis();
        time=end-start;
        speicherbedarf+=(array.length+1)*32;
    }

    /**
     * Hier werden alle Teil-programme des Algorithmus ausgeführt.
     */
    private void binaryTreeSort(){
        Knoten mainKnoten = new Knoten(array[0]);
        zahlenEintragen(mainKnoten);
        zahlenAuslesen(mainKnoten);
    }

    /**
     * Diese Methode verwandelt das Array in eine Baum Datenstruktur und setzt die Werte sortiert ein
     * @param mainKnoten Der Hauptknoten der Datenstruktur
     */
    private void zahlenEintragen(Knoten mainKnoten){
        for (int i = 1; i < array.length; i++) {
            zahlEintragen(array[i], mainKnoten);
            anzVergleiche++;
        }
        anzVergleiche++;
        speicherbedarf+=32;
    }

    /**
     * Die Werte des Arrays werden im Baum eingetragen
     * @param zahl Das ist der Wert einer Zahl vom Array wo im Baum eingetragen wird
     * @param knoten Das ist der Knoten, in dem sich der Baum befindet
     */
    private void zahlEintragen(int zahl, Knoten knoten){
        if (zahl<knoten.wert){
            if (knoten.linkerKnoten==null){
                knoten.linkerKnoten=new Knoten(zahl);
                anzahlSchreibzugriffe++;
            }else{
                zahlEintragen(zahl,knoten.linkerKnoten);
            }

        }else{

            if (knoten.rechterKnoten==null){
                knoten.rechterKnoten=new Knoten(zahl);
                anzahlSchreibzugriffe++;
            }else{
                zahlEintragen(zahl,knoten.rechterKnoten);
            }

        }
        anzVergleiche+=2;
        speicherbedarf+=32;
    }

    /**
     * Diese Rekursive Methode liest alle Werte aus der Baum Datenstruktur
     * @param knoten Der Knoten wo sich der Algorithmus befindet
     */
    private void zahlenAuslesen(Knoten knoten){
        if (knoten.linkerKnoten!=null){
            zahlenAuslesen(knoten.linkerKnoten);
        }

        array[index]= knoten.wert;
        index++;
        anzahlSchreibzugriffe++;

        if (knoten.rechterKnoten!=null){
            zahlenAuslesen(knoten.rechterKnoten);
        }
        anzVergleiche+=2;
    }

}