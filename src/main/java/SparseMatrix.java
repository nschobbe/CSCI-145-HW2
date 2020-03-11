public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;

    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;

        firstRow = new MatrixRow();
        MatrixRow prevRow = firstRow;

        for(int i = 1; i <= rows; i++) {
            // create a new matrix row
            MatrixRow nextRow = new MatrixRow();
            // make it the successor of the previous
            prevRow.setNext(nextRow);
            prevRow = nextRow;
            //System.out.println("Row " + i + " created");
        }

        firstColumn = new MatrixColumn();
        MatrixColumn prevColumn = firstColumn;

        for(int j = 1; j <= columns; j++) {
            MatrixColumn nextColumn = new MatrixColumn();
            prevColumn.setNext(nextColumn);
            prevColumn = nextColumn;
            //System.out.println("Column " + j + " created");
        }
    }

    public void insert(int row, int column, int value) {
        ValueNode node = new ValueNode(row, column, value); //creating new ValueNode to be inserted
        MatrixRow tempRow;
        MatrixColumn tempCol;
        
        tempRow = this.firstRow; //iterate through the list of MatrixRows until the right one, insert Node into MatrixRow 
        for (int i = 0; i < row - 1; i++) {
            //System.out.println(value + " this is the value");
            if(tempRow.getNext() != null) {
                tempRow = tempRow.getNext();
            }
        }
        tempRow.insert(node);

        tempCol = this.firstColumn; //same as the rows, but with MatrixColumns instead
        for (int j = 0; j < column - 1; j++) {
            //System.out.println(tempCol);
            tempCol = tempCol.getNext();

        }
        //System.out.println(tempCol);
        tempCol.insert(node);
    }

    public MatrixRow getRow(int position) {
        MatrixRow temp = firstRow;
        for(int i = 1; i < position; i++){
            temp = temp.getNext();
        }
        return temp;
    }

    public MatrixColumn getColumn(int position) {
        MatrixColumn temp = firstColumn;
        for(int i = 1; i < position; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public int getValue(int row, int column) {
        MatrixRow tRow = this.firstRow;
        for (int i = 0; i < row; i++) {
            tRow = tRow.getNext();
        }
        if (tRow.get(column) == -1) {
            return 0;
        }
        else {
            return tRow.get(column);
        }
    }

    public void print() {
        for (int i = 0; i < this.totalRows; i++) {
            for (int j = 1; j <= this.totalColumns; j++) {
                System.out.print(this.getValue(i, j) + " ");
            }
            System.out.println();
        }
    }

    public SparseMatrix transpose() {
        return null;
    }

    public SparseMatrix product(SparseMatrix other) {
        return null;
    }
}