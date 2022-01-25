import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 18.01.2022
 */
public class SorterTest {
    int[] arrayUnsorted;
    int[] arraySorted;

    @Before
    public void initialize() {
        Random random = new Random(); // creating Random object
        arrayUnsorted = new int[100000];
        for (int i = 0; i < arrayUnsorted.length; i++) {
            arrayUnsorted[i] = (int) (Math.random() * 100000000);
        }
        arraySorted = arrayUnsorted.clone();

        Arrays.sort(arraySorted);
    }

    @Test
    public void binaryTreeSort() {
        BinaryTreeSort sorter = new BinaryTreeSort();
        sorter.sort(arrayUnsorted);
        assertArrayEquals(arrayUnsorted, arraySorted);
    }

    @Test
    public void heapSort() {
        HeapSort sorter = new HeapSort();
        sorter.sort(arrayUnsorted);
        assertArrayEquals(arrayUnsorted, arraySorted);
    }

    @Test
    public void insertionSort() {
        InsertionSort sorter = new InsertionSort();
        sorter.sort(arrayUnsorted);
        assertArrayEquals(arrayUnsorted, arraySorted);
    }

    @Test
    public void mergeSort() {
        MergeSort sorter = new MergeSort();
        sorter.sort(arrayUnsorted);
        assertArrayEquals(arrayUnsorted, arraySorted);
    }

    @Test
    public void quickSortFirstPivot() {
        QuickSortFirstPivot sorter = new QuickSortFirstPivot();
        sorter.sort(arrayUnsorted);
        assertArrayEquals(arrayUnsorted, arraySorted);
    }

    @Test
    public void quickSortRandomPivot() {
        QuickSortRandomPivot sorter = new QuickSortRandomPivot();
        sorter.sort(arrayUnsorted);
        assertArrayEquals(arrayUnsorted, arraySorted);
    }

    @Test
    public void shakerSort() {
        ShakerSort sorter = new ShakerSort();
        sorter.sort(arrayUnsorted);
        assertArrayEquals(arrayUnsorted, arraySorted);
    }

    @Test
    public void all() {
        SorterInterface[] sorter = new SorterInterface[7];

        sorter[0] = new BinaryTreeSort();
        sorter[1] = new HeapSort();
        sorter[3] = new MergeSort();
        sorter[4] = new QuickSortFirstPivot();
        sorter[5] = new QuickSortRandomPivot();
        sorter[2] = new InsertionSort();
        sorter[6] = new ShakerSort();
        for (SorterInterface sorterIf : sorter) {
            initialize();
            try {
                sorterIf.sort(arrayUnsorted);
                assertArrayEquals(arrayUnsorted, arraySorted);
                System.out.println(sorterIf.getClass() + "\t\tWorked");
            } catch (Exception e) {
                System.out.println(sorterIf.getClass() + "\t\tdidn't Worked");
            }
        }
    }
}
