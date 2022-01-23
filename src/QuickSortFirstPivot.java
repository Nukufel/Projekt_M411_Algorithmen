/**
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class QuickSortFirstPivot extends SortAttributes{

    @Override
    public void sort(int[]zahlen){

        resetAttributes();

        long start = System.currentTimeMillis();

        array=zahlen;

        quickSort(0,array.length-1);

        long end = System.currentTimeMillis();

        time=end-start;
        speicherbedarf+=array.length*32;
    }

    private void quickSort(int left, int right) {
        if (left < right) {

            int pivot = array[left];
            int counterLeft = left;
            int counterRight = right;
            speicherbedarf+=3*32;

            while (counterLeft < counterRight) {
                counterLeft++;

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
            anzVergleiche++;
            changePos(left, counterRight);

            quickSort(left, counterRight - 1);
            quickSort(counterRight + 1, right);

        }
        speicherbedarf+=2*32;
        anzVergleiche++;
    }

    private void changePos(int index1,int index2){
        int num=array[index1];
        array[index1]=array[index2];
        array[index2]=num;
        anzahlSchreibzugriffe+=2;
        speicherbedarf+=3*32;
    }
}
