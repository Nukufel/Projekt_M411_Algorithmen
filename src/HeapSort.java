/**
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class HeapSort extends SortAttributes {

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


    private void heapSort() {
        BuildMaxHeap();
        // Sortierung:
        for (int i = array.length - 1; i > 0; i--) {
            changePos(i, 0);
            versickern(0, i);
            anzVergleiche++;
        }
        speicherbedarf += 32;

    }

    // Erstelle im Array einen MaxHeap Baum
    private void BuildMaxHeap() {
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            versickern(i, array.length);
            anzVergleiche++;
        }
        speicherbedarf += 32;
    }

    // Versickern – Downheap
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
