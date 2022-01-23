import java.util.Random;

/**
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class QuickSortRandomPivot extends SortAttributes{

    @Override
    public void sort(int[]zahlen){

        resetAttributes();

        long start = System.currentTimeMillis();

        array=zahlen;

        anzahlSchreibzugriffe++;

        quickSort(0,array.length-1);

        long end = System.currentTimeMillis();

        time=end-start;
        speicherbedarf=(array.length)*32;
    }

    /**
     * This is the algorithm
     * @param left This is the left Bound of the Group
     * @param right This is the right Bound of the Group
     */
    private void quickSort(int left, int right) {
        if (left < right) {
            //Replacing the first value with a random of the same Range
            int random=left+(int)(Math.random()*(right-left));
            changePos(left,random);

            int pivot = array[left];

            int counterLeft = left;
            int counterRight = right;

            speicherbedarf+=3*32;

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
                anzVergleiche+=4;
            }

            speicherbedarf+=2*32;
            changePos(left, counterRight);

            quickSort(left, counterRight - 1);
            quickSort(counterRight + 1, right);
        }
    }


    private void changePos(int index1,int index2){
        int num=array[index1];
        array[index1]=array[index2];
        array[index2]=num;
        speicherbedarf+=3*32;
        anzahlSchreibzugriffe+=2;
    }
}
