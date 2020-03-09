public class MatrixColumn {
    private ValueNode first;
    private MatrixColumn next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixColumn getNext() {
        return next;
    }

    public void setNext(MatrixColumn next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
// responsible for inserting values into the list in sorted order
    }

    public int get(int position) {
        ValueNode temp = first;
        int value;

        while(temp != null && temp.getRow() < position){
            temp = temp.getNextRow();
        }
        if(temp == null){
            value = -1;
        }
        if(temp.getRow() != position){
            value = 0;
        }
        else{
            value = temp.getValue();
        }
        return value;
    }

}