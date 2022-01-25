/**
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class ShakerSort extends SortAttributes {

    @Override
    public void sort(int[] zahlen) {
        resetAttributes();

        long start = System.currentTimeMillis();

        array = zahlen;
        shakerSort();

        long end = System.currentTimeMillis();

        time = start - end;
        speicherbedarf = (array.length + 3) * 32;
    }

    /**
     * protected int anzahlSchreibzugriffe;
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

    private void changePos(int index1, int index2) {
        int num = array[index1];
        array[index1] = array[index2];
        array[index2] = num;
        speicherbedarf += 32 * 3;
        anzahlSchreibzugriffe += 2;
    }

}
