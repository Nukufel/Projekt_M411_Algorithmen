

/**
 * Es wird zuerst ein Pivot bestummen. Dieser Pivot ist der erste Wert des Array-Blockes. Dann werden grössere Werte
 * als der Pivot rechts und kleinere Werte links gespeichert.
 * Nun wird das selbe nochmal gemacht, mit dem Unterschied dass der neue Array-Block nur die linke hälfte des Array ist.
 * Das selbe macht man dann mit der rechten hälfte des Arrays.
 *
 * Stabil: Nein
 * Bestcase: O(n*log(n))
 * Averagecase: O(n*log(n))
 * Worstcase: O(n^2)
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class QuickSortRandomPivot extends SortAttributes {

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

        anzahlSchreibzugriffe++;

        quickSort(0, array.length - 1);

        long end = System.currentTimeMillis();

        time = end - start;
        speicherbedarf = (array.length) * 32;
    }

    /**
     * Diese Methode ist der Algorithmus
     * @param left Das ist das linke Ende, des Array-blocks
     * @param right Das ist das rechte Ende, des Array-blocks
     */
    private void quickSort(int left, int right) {
        if (left < right) {
            //Replacing the first value with a random of the same Range
            int random = left + (int) (Math.random() * (right - left));
            changePos(left, random);

            int pivot = array[left];

            int counterLeft = left;
            int counterRight = right;

            speicherbedarf += 3 * 32;

            while (counterLeft < counterRight) {
                // move right to avoid pivot element
                counterLeft++;
                anzVergleiche++;

                while (counterLeft <= right && array[counterLeft] < pivot) {
                    counterLeft++;
                    anzVergleiche++;
                }

                while (counterRight >= left && array[counterRight] > pivot) {
                    counterRight--;
                    anzVergleiche++;
                }

                if (counterLeft <= right && counterLeft < counterRight) {
                    changePos(counterLeft, counterRight);
                }
                anzVergleiche += 4;
            }

            speicherbedarf += 2 * 32;
            changePos(left, counterRight);

            quickSort(left, counterRight - 1);
            quickSort(counterRight + 1, right);
        }
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
        speicherbedarf += 3 * 32;
        anzahlSchreibzugriffe += 2;
    }
}
