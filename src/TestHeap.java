import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestHeap 
{

        public static void main(String[] args) 
        {
            File file1 = new File("data_random.txt");
            File file2 = new File("data_sorted.txt");

            outputMaxHeapWithOptimalMethod(file1);
        }

        private static void outputMaxHeapWithSequentialInsertion(File givenFile)
        {

        }

        private static void outputMaxHeapWithOptimalMethod(File givenFile)
        {
            Integer a[] = new Integer [100];

            //Input the data from the file
            try {
                int i=0;
                File file = givenFile;
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine())
                {
                    String num = scanner.nextLine(); //Input data from each line of the file
                    a[i] = Integer.parseInt(num);
                    i++;
                }
                scanner.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("The file does not exist.");
                e.printStackTrace();
            }

            //write the data to the output file
            try {
                //open a file to write data
                PrintWriter f = new PrintWriter("output.txt");
                MaxHeap <Integer> newheap = new MaxHeap<>(a);

                //Optimal method
                newheap.optimalMethod(a);
                f.write("Heap built using optimal method: ");

                //Print out the heap
                for(int i = 1; i <= 10; i++)
                {
                    f.write(newheap.getData(i) + ", ");
                }

                f.write("...\n");

                //Print out the number of swaps
                f.write("Number of swaps in the heap creation: " + newheap.getSwap() + "\n" );

                //Removeals on heap
                for(int i = 1; i<= 10; i++)
                {
                    newheap.removeMax();
                }

                //Print out the heap after 10 removal
                f.write("Heap after 10 removals: ");
                for(int i = 1; i <= 10; i++)
                {
                    f.write(newheap.getData(i) + ", ");
                }
                f.write("...\n");

                f.close();


            }
            catch(FileNotFoundException e)
            {
                System.out.println("Cannot write data to the file");
            }
        }
}
