/**
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 13.01.2022
 */
public class HeapSort extends SortAttributes{

    @Override
    public void sort(int[] zahlen) {
        resetAttributes();

        long start = System.currentTimeMillis();

        array=zahlen;
        heapSort();

        long end = System.currentTimeMillis();

        time=end-start;
        speicherbedarf+= array.length*32;
    }



    private void heapSort() {
        BuildMaxHeap(array);
        // Sortierung:
        for(int i = array.length -1; i > 0; i--) {
            tausche(array, i, 0);
            versickern(array, 0, i);
            anzVergleiche++;
        }
        speicherbedarf+=32;

    }

    // Erstelle im Array einen MaxHeap Baum
    private void BuildMaxHeap(int[] arr) {
        for(int i = (arr.length / 2) - 1; i >= 0 ; i--) {
            versickern(arr, i, arr.length);
            anzVergleiche++;
        }
        speicherbedarf+=32;
    }

    // Versickern – Downheap
    private void versickern(int[] arr, int i, int j) {
        speicherbedarf+=32*2;
        while(i <= (j / 2) - 1) {

            // linkes Kind
            int kindIndex = ((i+1) * 2) - 1;
            // rechtes Kind
            if((kindIndex + 1 <= j -1) &&(arr[kindIndex] < arr[kindIndex+1])) {
                    kindIndex++;
            }
            // Test, ob Versickern notwendig ist
            if(arr[i] < arr[kindIndex]) {
                tausche(arr,i,kindIndex);
                i = kindIndex;
            } else break;
            speicherbedarf+=32;
            anzVergleiche+=3;
        }
        anzVergleiche++;
    }
    // Tauschen
    private void tausche(int[] arr, int i, int kindIndex) {
        int k = arr[i];
        arr[i] = arr[kindIndex];
        arr[kindIndex] = k;
        anzahlSchreibzugriffe+=2;
        speicherbedarf+=32*3;
    }
}
