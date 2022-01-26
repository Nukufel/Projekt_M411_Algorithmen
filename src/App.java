/**
 * @author Niklas Vogel
 * @version 1.1
 * @since 13.01.2022
 *
 * In this class data is read from documents and written into an array.
 * Then the data is sorted with each sort algorithm and
 * the sort time, number of writes, number of comparisons and the memory space
 * afterwards is written into a VSC file.
 */

import java.io.*;
import java.util.Vector;


public class App {
    /**
     * The data from the files will be written in to the array
     */
    private Vector<int[]> datenArrays = new Vector<>();

    /**
     *  In this vector an array is created for each algorithm,
     *  in which the sort time, the number of writes,
     *  the number of comparisons and the storage space will be inside
     */
    private Vector<Object[]> sortedArrays = new Vector<>();

    /**
     * All file pathes are written in the array
     */
    private String[] dateiEndungen = new File(new File("").getAbsolutePath() + "/Testdaten").list();

    /**
     * Classes are generated and stored in to an array
     */
    private SorterInterface[] sortingClasses = {new HeapSort(), new InsertionSort(), new MergeSort(), new QuickSortFirstPivot(), new QuickSortRandomPivot(), new ShakerSort(), new BinaryTreeSort()};

    /**
     * Sort algorithem names are stored into an array
     */
    private String[] sorts = {"HeapSort", "InsertionSort", "MergeSort", "QuickSortFirstPivot", "QuickSortRandomPivot", "ShakerSort", "BinaryTreeSort"};

    /**
     * File names are stored into an array
     */
    private String[] arrayNames = {"InversTeilsortiert1000", "InversTeilsortiert10000", "InversTeilsortiert100000", "Random1000", "Random10000", "Random100000", "Teilsortiert1000", "Teilsortiert10000", "Teilsortiert100000"};

    /**
     * Creates a BufferedReader "reader" to read the file paths and a second "reader2" to read the file length.
     *
     * @throws IOException
     */
    public void getFileformFile() throws IOException {
        for (int i = 0; i < dateiEndungen.length; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/Testdaten/" + dateiEndungen[i]));
            BufferedReader reader2 = new BufferedReader(new FileReader(new File("").getAbsolutePath() + "/Testdaten/" + dateiEndungen[i]));

            datenArrays.add(readInToArray(reader, reader2));

        }
    }

    /**
     * The reader reads the numbers from the file and stores them in an array.
     *
     * @param reader
     * @param reader2
     * @return Array filled with the numbers from the file.
     * @throws IOException
     */
    public int[] readInToArray(BufferedReader reader, BufferedReader reader2) throws IOException {
        int lines = (int) reader2.lines().count();

        int[] intArray = new int[lines];


        for (int j = 0; j < lines; j++) {
            intArray[j] = Integer.parseInt(reader.readLine());

        }
        return intArray;
    }

    /**
     * The sorting algorithms are called and the name,
     * the number of writes, the number of compares,
     * the memory requirements and the sorting time are
     * written into an array that is put into a vector via method calls.
     */
    public void sortingArrays() {

        for (int i = 0; i < sortingClasses.length; i++) {
            for (int[] dasArray : datenArrays) {
                sortingClasses[i].sort(dasArray.clone());
                Object[] theArrayAndStuff = {sortingClasses[i].getSortedArray(), sortingClasses[i].anzahlSchreibzugriffe(), sortingClasses[i].anzVergleiche(), sortingClasses[i].getSpeicherbedarf(), sortingClasses[i].getTime()};
                sortedArrays.add(theArrayAndStuff);
            }
        }
    }

    /**
     * The data is formatted and written from the array of the vector into a CSV file.
     *
     * @throws IOException
     */
    public void writeInToFile() throws IOException {
        FileWriter writer;
        File endFile = new File("endFile");
        String intoCSV = "";

/*
        for (int i = 0; i < 7; i++) {
            intoCSV += "\n" + sorts[i] + "\n";
            intoCSV += ",Schreibzugriffe,Vergleiche,Speicherbedarf,Time\n";
            for (int n = 0; n < 9; n++) {
                      intoCSV += arrayNames[n] + "," + sortedArrays.get((i * 9) + n)[1] + "," + sortedArrays.get((i * 9) + n)[2] + "," + sortedArrays.get((i * 9) + n)[3] + "," + sortedArrays.get((i * 9) + n)[4] + "\n";
            }
        }
 */
        for(int x = 1; x<=4; x++) {
            switch (x) {
                case 1 -> intoCSV += "\n"+"Schreibzugriffe";
                case 2 -> intoCSV += "\n"+"Vergleiche";
                case 3 -> intoCSV += "\n"+"Speicherbedarf";
                case 4 -> intoCSV += "\n" + "Time";
            }

                for (int i = 0; i < 7; i++) {
                intoCSV += "," + sorts[i];
            }

            for (int n = 0; n < 9; n++) {
                intoCSV += "\n" + arrayNames[n];
                for (int i = 0; i < 7; i++) {
                    intoCSV += "," + sortedArrays.get((i * 9) + n)[x];
                }
            }
            intoCSV += "\n";
        }

        intoCSV += "\n";


        writer = new FileWriter(endFile+".csv", false);
        writer.write(intoCSV);
        writer.flush();
        writer.close();

    }

    public static void main(String[] args) throws IOException {
        App managerin = new App();
        managerin.getFileformFile();
        managerin.sortingArrays();
        managerin.writeInToFile();
    }
}
