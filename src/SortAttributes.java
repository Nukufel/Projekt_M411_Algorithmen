/**
 * Das ist eine Vorlage für alle anderen Sort Klassen
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 12.01.2022
 */
public abstract class SortAttributes implements SorterInterface {
    /**
     * Das ist das Array, das sortiert wird
     */
    protected int[] array;
    /**
     * Das ist der Speicherbedarf, wo der Algorithmus verbraucht hat.
     */
    protected long speicherbedarf;
    /**
     * Das ist die Zeit, wo der Algorithmus gebraucht hat.
     */
    protected long time;
    /**
     * Das ist die Anzahl Vergleichen, wo der Algorithmus genutzt hat.
     */
    protected long anzVergleiche;
    /**
     * Das ist die Anzahl Schreibzugriffe, wo der Algorithmus genutzt hat.
     */
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
     * setz alle Werte eines SortAttributes Objekts zurück.
     */
    protected void resetAttributes() {
        array = null;
        speicherbedarf = 0;
        time = 0;
        anzVergleiche = 0;
        anzahlSchreibzugriffe = 0;
    }
}
