
public class Homework2 {
    public static void main(String[] args){
        MatrixReader matrixReader = new MatrixReader();
        SparseMatrix matrixA = matrixReader.read("matrixA.txt");
        SparseMatrix matrixB = matrixReader.read("matrixB.txt");
        matrixA.print();
        matrixB.print();


    }
}