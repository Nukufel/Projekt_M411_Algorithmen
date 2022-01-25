

import java.io.*;
import java.util.Vector;


public class Managerin {
    private Vector<int[]> datenArrays = new Vector<>();
    private Vector<Object[]> sortedArrays = new Vector<>();

    private String[] dateiEndungen = new File(new File("").getAbsolutePath() + "/Testdaten").list();
    private SorterInterface[] sortingClasses = {new HeapSort(), new InsertionSort(), new MergeSort(), new QuickSortFirstPivot(), new QuickSortRandomPivot(), new ShakerSort(), new BinaryTreeSort()};
    private String[] sorts = {"HeapSort", "InsertionSort", "MergeSort", "QuickSortLeftPivot", "QuickSortRandomPivot", "ShakerSort", "BinaryTreeSort"};
    private String[] arrayNames = {"InversTeilsortiert1000", "InversTeilsortiert10000", "InversTeilsortiert100000", "Random1000", "Random10000", "Random100000", "Teilsortiert1000", "Teilsortiert10000", "Teilsortiert100000"};

    public Managerin() {
    }

    public void getFileformFile() throws IOException {
        for (int i = 0; i < dateiEndungen.length; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/Testdaten/" + dateiEndungen[i]));
            BufferedReader reader2 = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/Testdaten/" + dateiEndungen[i]));

            datenArrays.add(readInToArray(reader, reader2));

        }
    }

    public int[] readInToArray(BufferedReader reader, BufferedReader reader2) throws IOException {
        int lines = (int) reader2.lines().count();

        int[] intArray = new int[lines];


        for (int j = 0; j < lines; j++) {
            intArray[j] = Integer.parseInt(reader.readLine());

        }
        return intArray;
    }

    public void sortingArrays() {

        for (int i = 0; i < sortingClasses.length; i++) {
            for (int[] dasArray : datenArrays) {
                sortingClasses[i].sort(dasArray.clone());
                Object[] theArrayAndStuff = {sortingClasses[i].getSortedArray(), sortingClasses[i].anzahlSchreibzugriffe(), sortingClasses[i].anzVergleiche(), sortingClasses[i].getSpeicherbedarf(), sortingClasses[i].getTime()};
                sortedArrays.add(theArrayAndStuff);
            }
        }
    }

    public void writeInToFile() throws IOException {
        FileWriter writer;
        File endFile = new File("endFile.txt");
        String intoCSV = "";

        for (int i = 0; i < 7; i++) {
            intoCSV += "\n" + sorts[i] + "\n";
            intoCSV += ",Schreibzugriffe,Vergleiche,Speicherbedarf,Time\n";
            for (int n = 0; n < 9; n++) {
                intoCSV += arrayNames[n] + "," + sortedArrays.get((i * 7) + n)[1] + "," + sortedArrays.get((i * 7) + n)[2] + "," + sortedArrays.get((i * 7) + n)[3] + "," + sortedArrays.get((i * 7) + n)[4] + "\n";
            }
        }


        writer = new FileWriter(endFile, false);
        writer.write(intoCSV);
        writer.flush();
        writer.close();

    }

    public static void main(String[] args) throws IOException {
        Managerin managerin = new Managerin();
        managerin.getFileformFile();
        managerin.sortingArrays();
        managerin.writeInToFile();
    }
}
