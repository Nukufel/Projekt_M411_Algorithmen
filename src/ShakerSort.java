/**
 * Dieser Algorithmus vergleicht zwei Werte des Arrays, die neben einander sind. Falls der rechte Wert grösser
 * ist als der linke werden diese vertauscht. Nacher geht es eine stelle weiter nach vorne. Wenn es einmal durch das
 * ganze Array geht wird das selbe rückwerts gemacht. Dies wird solange gemacht bis das Array sortiert ist.
 *
 * Stabil: Ja
 * Bestcase: O(n)
 * Averagecase: O(n^2))
 * Worstcase: O(n^2)
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class ShakerSort extends SortAttributes {

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
        shakerSort();

        long end = System.currentTimeMillis();

        time = end - start;
        speicherbedarf = (array.length + 3) * 32;
    }

    /**
     * Das ist der Algorithmus.
     */
    private void shakerSort() {
        boolean sorted = false;
        speicherbedarf += 2;
        while (!sorted) {
            sorted = true;
            //vorwärts
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    changePos(i, i + 1);
                    sorted = false;
                }
                //Vergleich in
                anzVergleiche += 2;
            }
            speicherbedarf += 32;

            //rückwerts
            for (int i = array.length - 2; i >= 0; i--) {
                if (array[i] > array[i + 1]) {
                    changePos(i, i + 1);
                    sorted = false;
                }
                anzVergleiche += 2;
            }
            speicherbedarf += 32;
            anzVergleiche++;
        }
        anzVergleiche++;
    }

    /**
     * Tauscht die Werte des Arrays an diesen stellen.
     * @param index1 Der Wert an dieser Stelle des Arrays wird mit Index 2 verschoben
     * @param index2 Der Wert an dieser Stelle des Arrays wird mit Index 1 verschoben
     */
    private void changePos(int index1, int index2) {
        int num = array[index1];
        array[index1] = array[index2];
        array[index2] = num;
        speicherbedarf += 32 * 3;
        anzahlSchreibzugriffe += 2;
    }

}
