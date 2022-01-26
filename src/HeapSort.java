/**
 * Das Array wird in einer Baum Datenstruktur abgespeichert. Diese hat die Regel, das der obere Knotenpunkt immer
 * grösser ist als der untere. Der Oberste Wert wird dann an der hintersten Stelle des Arrays gesetz. Dann wird wieder
 * die Regek der Datenstruktur, die nur zum leicht verändert worden ist, wieder hergestellt. Dieser vorgang wird
 * immer wieder holt bis alle Werte des Arrays ausgefüllt werden.
 *
 * Stabil: Nein
 * Bestcase: O(n*log(n))
 * Averagecase: O(n*log(n))
 * Worstcase: O(n*log(n))
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class HeapSort extends SortAttributes {

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
        heapSort();

        long end = System.currentTimeMillis();

        time = end - start;
        speicherbedarf += array.length * 32;
    }

    /**
     * Hier werden alle Teilprogramme des Algorithmus ausgeführt.
     */
    private void heapSort() {
        buildMaxHeap();
        // Sortierung:
        for (int i = array.length - 1; i > 0; i--) {
            changePos(i, 0);
            versickern(0, i);
            anzVergleiche++;
        }
        speicherbedarf += 32;

    }

    /**
     * Hier werden alle Werte des Arrays in die Datenstruktur hinzugefügt und so sortiert, das die Regel
     * eingehalten werden.
     */
    private void buildMaxHeap() {
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            versickern(i, array.length);
            anzVergleiche++;
        }
        speicherbedarf += 32;
    }

    /**
     * Hier wird geschaut ob die Regeln der Datenstruktur noch gelten und falls nicht dann wird dies korriegirt.
     * Dannach wird die höchste Zahl nach rechts verschoben
     * @param i tiefste Zahl
     * @param j oberste Zahl
     */
    private void versickern(int i, int j) {
        speicherbedarf += 32 * 2;
        while (i <= (j / 2) - 1) {
            // linkes Kind
            int kindIndex = ((i + 1) * 2) - 1;
            // rechtes Kind
            if ((kindIndex + 1 <= j - 1) && (array[kindIndex] < array[kindIndex + 1])) {
                kindIndex++;
            }
            // Test, ob Versickern notwendig ist
            if (array[i] < array[kindIndex]) {
                changePos(i, kindIndex);
                i = kindIndex;
            } else break;
            speicherbedarf += 32;
            anzVergleiche += 3;
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
