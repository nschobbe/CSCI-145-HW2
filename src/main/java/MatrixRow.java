public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }

    public void setNext(MatrixRow next) {
        this.next = next;
    }

    public void insert(ValueNode value) {

    }

    public int get(int position) {
        ValueNode temp = first;
        int value;

        while(temp != null && temp.getColumn() < position){
            temp = temp.getNextColumn();
        }
        if(temp == null){
            value = -1;
        }
        if(temp.getColumn() != position){
            value = 0;
        }
        else{
            value = temp.getValue();
        }
        return value;
    }

}