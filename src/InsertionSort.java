/**
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class InsertionSort extends SortAttributes {

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


    public void insertionSort() {
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
