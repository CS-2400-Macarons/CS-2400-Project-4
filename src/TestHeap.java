import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestHeap 
{

    public static void main(String[] args)
    {
        Integer[] sortedInsert = new Integer [100];
        Integer[] randomInsert = new Integer [100];
        Integer[] sortedOptimal = new Integer [100];
        Integer[] randomOptimal = new Integer [100];

        //Input the data from the file the file data_sorted.txt
        try {
            int i=0;
            File file1 = new File("data_sorted.txt");
            Scanner scanner1 = new Scanner(file1);
            while (scanner1.hasNextLine())
            {
                String num1 = scanner1.nextLine(); //Input data from each line of the file
                sortedInsert[i] = Integer.parseInt(num1);
                sortedOptimal[i] = Integer.parseInt(num1);
                i++;
            }
            scanner1.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("The file does not exist.");
            e.printStackTrace();
        }

        //write the data to the output file
        try {
            //open a file to write data
            PrintWriter f =new PrintWriter("output_sorted.txt");
            MaxHeap <Integer> insertHeap = new MaxHeap<>(sortedInsert);
            MaxHeap <Integer> optimalHeap = new MaxHeap<>(sortedOptimal);

            //Sequential Insertion Method
            insertHeap.sequentialInsertion(sortedInsert);
            f.write("Heap built using sequential insertions: ");

            //Print out the heap
            for(int i = 1; i <= 10; i++)
            {
                f.write(insertHeap.getData(i) + ", ");
            }
            f.write("...\n");

            //Print out the number of swaps
            f.write("Number of swaps in the heap creation: " + insertHeap.getSwap() + "\n" );

            //Removals on heap
            for(int i = 1; i<= 10; i++)
            {
                insertHeap.removeMax();
            }

            //Print out the heap after 10 removal
            f.write("Heap after 10 removals: ");
            for(int i = 1; i <= 10; i++)
            {
                f.write(insertHeap.getData(i) + ", ");
            }
            f.write("...\n\n");

            //Optimal method
            optimalHeap.optimalMethod(sortedOptimal);
            f.write("Heap built using optimal method: ");

            //Print out the heap
            for(int i = 1; i <= 10; i++)
            {
                f.write(optimalHeap.getData(i) + ", ");
            }
            f.write("...\n");

            //Print out the number of swaps
            f.write("Number of swaps in the heap creation: " + optimalHeap.getSwap() + "\n" );

            //Removals on heap
            for(int i = 1; i<= 10; i++)
            {
                optimalHeap.removeMax();
            }

            //Print out the heap after 10 removal
            f.write("Heap after 10 removals: ");
            for(int i = 1; i <= 10; i++)
            {
                f.write(optimalHeap.getData(i) + ", ");
            }
            f.write("...\n");

            f.close();


        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot write data to the file");

        }


        //Input the data from the file data_random.txt
        try {
            int k =0;
            File file2 = new File("data_random.txt");
            Scanner scanner2 = new Scanner(file2);
            while (scanner2.hasNextLine())
            {
                String num2 = scanner2.nextLine(); //Input data from each line of the file
                randomOptimal[k] = Integer.parseInt(num2);
                k++;
            }
            scanner2.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("The file does not exist.");
            e.printStackTrace();
        }

        //write the data to the output file
        try {
            //open a file to write data
            PrintWriter f2 =new PrintWriter("output_random.txt");
            MaxHeap <Integer> newheap2 = new MaxHeap<>(randomOptimal);

            //Sequential Insertion Method


            //Optimal method
            newheap2.optimalMethod(randomOptimal);
            f2.write("Heap built using optimal method: ");

            //Print out the heap
            for(int i = 1; i <= 10; i++)
            {
                f2.write(newheap2.getData(i) + ", ");
            }

            f2.write("...\n");

            //Print out the number of swaps
            f2.write("Number of swaps in the heap creation: " + newheap2.getSwap() + "\n" );

            //Removeals on heap
            for(int i = 1; i<= 10; i++)
            {
                newheap2.removeMax();

            }

            //Print out the heap after 10 removal
            f2.write("Heap after 10 removals: ");
            for(int i = 1; i <= 10; i++)
            {
                f2.write(newheap2.getData(i) + ", ");
            }
            f2.write("...\n");

            f2.close();


        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot write data to the file");
        }

    }
}
