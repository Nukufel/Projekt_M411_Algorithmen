import java.io.*;
import java.util.Vector;

public class Managerin{
    private Vector<int[]> datenArrays = new Vector<>();
    private Vector<Object[]> sortedArrays = new Vector<>();

    private String[] dateiEndungen = new File(new File("").getAbsolutePath()+"/Testdaten").list();
    private SorterInterface[] sortingClasses = {(SorterInterface) new QuickSortPrandom(), (SorterInterface) new BinaryTreeSort(), (SorterInterface)new HeapSort(),(SorterInterface) new InsertionSort(), (SorterInterface) new MergeSort(), (SorterInterface) new QuickSortPleft(), (SorterInterface) new ShakerSort()};
    private String [] sorts = {"QuickSortPrandom", "BinaryTreeSort", "HeapSort", "InsertionSort", "MergeSort", "QuickSortPleft", "ShakerSort"};
    private String[] arrayNames = {"InversTeilsortiert1000", "InversTeilsortiert10000","InversTeilsortiert100000","Random1000","Random10000","Random100000","Teilsortiert1000","Teilsortiert10000","Teilsortiert100000"};

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

        for (int i = 0; i<sortingClasses.length; i++){
            for (int[] dasArray: datenArrays) {
                sortingClasses[i].sort(dasArray);
                Object[] theArrayAndStuff = {sortingClasses[i].getSortedArray(), sortingClasses[i].anzahlSchreibzugriffe(), sortingClasses[i].anzVergleiche(), sortingClasses[i].getSpeicherbedarf(), sortingClasses[i].getTime()};
                sortedArrays.add(theArrayAndStuff);
            }
        }
    }

    public void writeInToFile() throws IOException {
        FileWriter writer;
        File endFile = new File("endFile.txt");
        String intoCSV = "";

        for (int i = 0; i<7; i++){
            intoCSV = sorts[i]+"\n";
            intoCSV = ",Schreibzugriffe,Vergleiche,Speicherbedarf,Time\n";
            for (int n = 0; n<9; n++) {
                intoCSV = arrayNames[n]+","+sortedArrays.get((i*7)+n)[1]+","+sortedArrays.get((i*7)+n)[2]+","+sortedArrays.get((i*7)+n)[3]+","+sortedArrays.get((i*7)+n)[4]+"\n";
            }
        }

        writer = new FileWriter(endFile, false);
        writer.write(intoCSV);
        writer.flush();
        writer.close();

    }

    public static void main(String[] args) {

    }
}
