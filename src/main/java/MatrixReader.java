import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.*;

public class MatrixReader {

    public SparseMatrix read(String file){

        SparseMatrix matrix = null;

        try {
            File matrixFile = new File(file);
            Scanner input = new Scanner(matrixFile);

            //Consider using input.nextLine b/c might try to parse /n which might throw errors so just check when testing.
            int rows = Integer.parseInt(input.nextLine()); //parse the first input into an integer defining total rows.
            int columns = Integer.parseInt(input.nextLine()); // parse the second input into an integer defining total columns
            System.out.println("Rows: " + rows);
            System.out.println("Columns: " + columns);
            matrix = new SparseMatrix(rows, columns); //create sparce matrix
            int counter = 1; //counter for which row we are on

            while (input.hasNext()) {                            //While there is more in the text file: make a string array of the token created
                String[] token = input.nextLine().split("\\s+"); //by splitting the first line with spaces. (1,8)

                for (int i = 0; i < token.length - 1; i++) { //For every token in the array split them with commas and place them
                    String[] finalTokens = token[i].split(","); //in a new array called finalTokens.

                    int columnNumber = Integer.parseInt(finalTokens[0]); //parse finaltokens for integer at index 0.
                    int value = Integer.parseInt(finalTokens[1]); //parse final tokens for integer at index 1.

                 
                    matrix.insert(counter, columnNumber, value); //call matrix.insert with counter for row #, col #, and value
                    counter = counter + 1;
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }

        return matrix;
    }
}
//hopefully this works