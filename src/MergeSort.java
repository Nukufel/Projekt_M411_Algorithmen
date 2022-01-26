/**
 * Beim Merge Sort teilt man das Array Blöcke. Diese Blöcke werden so lange aufgeteilt, bis jedes Block 1 Wert gross ist.
 * Diese werden dann Stück für Stück wieder zusammen gefügt. Beim zusammenfügen werden die einzelnen teile wieder sortiert.
 *
 * Stabil: Ja
 * Bestcase: O(n*log(n))
 * Averagecase: O(n*log(n))
 * Worstcase: O(n*log(n))
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class MergeSort extends SortAttributes {

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
        mergeSort(array,array.length);

        long end = System.currentTimeMillis();

        speicherbedarf += array.length * 32;
        time = end - start;
    }

    /**
     * Das ist der Algorithmus. Hier wird das Array in vielen kleineren Arrays gespeichert.
     * Zum schluss dieser Methode werden diese kleineren Arrays zusammengefügt.
     * @param array Das ist der das, Array das in vielen kleinen Arrays aufgeiteilt wird.
     * @param length Das ist die länge des Blockes.
     */
    public void mergeSort(int[] array, int length) {


        if (length < 2) {
            return;
        }
        anzVergleiche++;

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        speicherbedarf += (array.length + 1) * 32;

        anzahlSchreibzugriffe += 2;

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
            anzVergleiche++;
            anzahlSchreibzugriffe++;
        }

        for (int i = middle; i < length; i++) {
            rightArray[i - middle] = array[i];

            anzVergleiche++;
            anzahlSchreibzugriffe++;
        }

        mergeSort(leftArray, middle);
        mergeSort(rightArray, length - middle);

        merge(array, leftArray, rightArray, middle, length - middle);
    }

    /**
     * Dieses Methode verbindet die zwei kleineren Array und fügt diese Zusammen und speichert dies im grösseren Array.
     * @param array Das ist das grössere Array, worin die zwei kleineren Array zusammen gefügt werden
     * @param leftArray Das ist das linke kleinere Array, wo nacher zum Teil des grösserens wird.
     * @param rightArray Das ist das rechte kleinere Array, wo nacher zum Teil des grösserens wird.
     * @param left Das ist die länge des linken Arrays.
     * @param right Das ist die länge des rechten Arrays.
     */
    public void merge(int[] array, int[] leftArray, int[] rightArray, int left, int right) {
        int i = 0, j = 0, k = 0;
        speicherbedarf += 5 * 32;


        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }

            anzahlSchreibzugriffe++;
            anzVergleiche += 2;
        }

        anzVergleiche++;

        while (i < left) {
            array[k++] = leftArray[i++];

            anzahlSchreibzugriffe++;
            anzVergleiche++;

        }
        anzVergleiche++;

        while (j < right) {
            array[k++] = rightArray[j++];
            anzahlSchreibzugriffe++;
            anzVergleiche++;
        }
        anzVergleiche++;
    }

}
