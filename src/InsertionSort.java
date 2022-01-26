/**
 * Zu beginn hat man das unsortierte Array. In diesem Array hat man einen sortierten Berreich.
 * Dieser Berreich ist zu beginn 0. Man fügt diesen Berreich den ersten Wert und stellt es in der richtigen Stelle.
 * Dannach wird der Berreich grösser und fügt diesen einen weiteren Wert zu. Dieser Wert wird wieder an der
 * richtigen Stelle eingefügt. Usw.
 *
 * Stabil: Ja
 * Bestcase: O(n)
 * Averagecase: O(n^2)
 * Worstcase: O(n^2)
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class InsertionSort extends SortAttributes {

    /**
     * Das Array wird Sortiert
     * Diese Methode ruft das Algorithmus auf
     * @param zahlen das Array das Sortiert werden sollte
     */
    @Override
    public void sort(int[] zahlen) {
        resetAttributes();

        long start = System.currentTimeMillis();

        array = zahlen;

        insertionSort();

        long end = System.currentTimeMillis();

        time = end - start;
        speicherbedarf += array.length * 32;
    }

    /**
     * Das hier ist der ganze Algorithmus
     */
    private void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int counter = i - 1;
            //Werte verschieben
            while ((counter > -1) && (array[counter] > key)) {
                array[counter + 1] = array[counter];
                counter--;

                anzahlSchreibzugriffe++;
                anzVergleiche++;
            }

            array[counter + 1] = key;
            anzVergleiche += 2;
            speicherbedarf += 2 * 32;
        }
    }
}
