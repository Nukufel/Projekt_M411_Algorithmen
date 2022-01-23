/**
 * Das ist eine Vorlage für alle anderen Sort Klassen
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 12.01.2022
 */
public abstract class SortAttributes implements SorterInterface{
    protected int[] array;
    protected long speicherbedarf;
    protected long time;
    protected long anzVergleiche;
    protected long anzahlSchreibzugriffe;

    /**
     * Das sortierte Array wird zurück gegeben.
     * @return das Array das sortiert worden ist
     */
    @Override
    public int[] getSortedArray() {
        return array;
    }

    /**
     * Der gebrauchten Speicherbedarf wird zurück gegeben.
     * @return den gebrauchten Speicherbedarf zum sortieren
     */
    @Override
    public long getSpeicherbedarf() {
        return speicherbedarf;
    }

    /**
     * Die gebrauchte Zeit wird zurück gegeben
     * @return die gebrauchte Zeit zum sortieren
     */
    @Override
    public long getTime() {
        return time;
    }

    /**
     * Die Anzahl vergleiche werden zurück gegeben
     * @return die Anzahl von Vergleiche zum sortieren
     */
    @Override
    public long anzVergleiche() {
        return anzVergleiche;
    }

    /**
     * Die Anzahl von Schreibzugriffen werden zurück gegeben
     * @return die Anzahl von Schreibzugriffen zum sortieren
     */
    @Override
    public long anzahlSchreibzugriffe() {
        return anzahlSchreibzugriffe;
    }

    /**
     * setz alle Werte eines SortAttributes Objekts zurück bevor dem Starten der Sortierung
     */
    protected void resetAttributes(){
        array=null;
        speicherbedarf=0;
        time=0;
        anzVergleiche=0;
        anzahlSchreibzugriffe=0;
    }
}
