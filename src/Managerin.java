import java.io.*;
import java.util.Vector;

public class Managerin{
    private Vector<int[]> datenArrays = new Vector<>();

    private String[] dateiEndungen = new File(new File("").getAbsolutePath()+"/Testdaten").list();
    private SorterInterface[] sortingClasses = {(SorterInterface) new BinaryTreeSort(), (SorterInterface)new HeapSort(),(SorterInterface) new InsertionSort(), (SorterInterface) new MergeSort(), (SorterInterface) new QuickSortPleft(), (SorterInterface) new ShakerSort()};

    public Managerin(){

    }

    public void getFileformFile() throws IOException {
        for (int i = 0; i<dateiEndungen.length; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/Testdaten/" + dateiEndungen[i]));
            datenArrays.add(readInToArray(reader));
        }
    }

    public int[] readInToArray(BufferedReader reader) throws IOException {
        int[] intArray = new int[(int)reader.lines().count()];
        for (int j = 0; j<reader.lines().count(); j++){
            intArray[j] = Integer.parseInt(reader.readLine());
        }
        return intArray;
    }

    public void sortingArrays() {
        SorterInterface sorterInterface = (SorterInterface) new BinaryTreeSort();
    }
}
