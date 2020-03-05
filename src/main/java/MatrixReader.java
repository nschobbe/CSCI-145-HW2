import java.util.Scanner;
import java.io.File;

public class MatrixReader {

    //should read rows and columns, then init a SparseMatrix object with those values
    //then, iterarte through the file row by row, inserting ValueNodes at the correct places
    //you will only ever have to insert to the end of any column list, but the order in the row lists is fucky
    //if you have two ValueNodes (a and b) and a third (c) needs to go between them, put b in a temp, 
    //break the reference from a to b
    //new reference goes a to c, then c.setNext(to the temp)
    public SparseMatrix read(String file) {
    }
        
}
