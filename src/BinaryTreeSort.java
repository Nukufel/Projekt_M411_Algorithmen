/**
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class BinaryTreeSort extends SortAttributes{
    private int index;

    private class Knoten{
        int wert;
        Knoten linkerKnoten,rechterKnoten;

        private Knoten(int wert) {
            this.wert = wert;
            speicherbedarf+=2*32;
        }
    }

    @Override
    public void sort(int[] zahlen) {
        resetAttributes();

        long start = System.currentTimeMillis();

        array=zahlen;
        binaryTreeSort();

        long end = System.currentTimeMillis();
        time=start-end;
        speicherbedarf+=(array.length+1)*32;
    }

    private void binaryTreeSort(){
        Knoten mainKnoten = new Knoten(array[0]);
        speicherbedarf+=32;
        zahlenEintragen(mainKnoten);
        zahlenAuslesen(mainKnoten);
    }
    private void zahlenEintragen(Knoten mainKnoten){
        for (int i = 1; i < array.length; i++) {
            zahlEintragen(array[i], mainKnoten);
            anzVergleiche++;
        }
        anzVergleiche+= array.length;
        speicherbedarf+=32;
    }
    private void zahlEintragen(int zahl, Knoten knoten){
        if (zahl<knoten.wert){

            if (knoten.linkerKnoten==null){
                knoten.linkerKnoten=new Knoten(zahl);
            }else{
                zahlEintragen(zahl,knoten.linkerKnoten);
            }

        }else{

            if (knoten.rechterKnoten==null){
                knoten.rechterKnoten=new Knoten(zahl);
            }else{
                zahlEintragen(zahl,knoten.rechterKnoten);
            }

        }
        anzahlSchreibzugriffe++;
        anzVergleiche+=2;
        speicherbedarf+=2*32;
    }

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