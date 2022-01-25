/**
 * Das ist das Interface, welche jede Sort Klasse hat.
 *
 * @author Niklas Vogel
 * @version 1.0
 * @since 12.01.2022
 */
public interface SorterInterface {
    /**
     * Das Array wird Sortiert
     *
     * @param zahlen das Array das Sortiert werden sollte
     */
    public void sort(int[] zahlen);

    /**
     * Das sortierte Array wird zurück gegeben.
     *
     * @return das sortierte Array
     */
    public int[] getSortedArray();

    /**
     * Der gebrauchten Speicherbedarf wird zurück gegeben.
     *
     * @return den gebrauchten Speicherbedarf zum sortieren
     */
    public long getSpeicherbedarf();

    /**
     * Die gebrauchte Zeit wird zurück gegeben
     *
     * @return die gebrauchte Zeit zum sortieren
     */
    public long getTime();

    /**
     * Die Anzahl vergleiche werden zurück gegeben
     *
     * @return die Anzahl von Vergleiche zum sortieren
     */
    public long anzVergleiche();

    /**
     * Die Anzahl von Schreibzugriffen werden zurück gegeben
     *
     * @return die Anzahl von Schreibzugriffen zum sortieren
     */
    public long anzahlSchreibzugriffe();
}
