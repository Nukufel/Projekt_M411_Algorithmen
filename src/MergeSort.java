/**
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class MergeSort extends SortAttributes {

    @Override
    public void sort(int[] zahlen) {

        resetAttributes();

        long start = System.currentTimeMillis();

        array = zahlen;
        mergeSort(zahlen, zahlen.length);

        long end = System.currentTimeMillis();

        speicherbedarf += array.length * 32;
        time = end - start;
    }

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
