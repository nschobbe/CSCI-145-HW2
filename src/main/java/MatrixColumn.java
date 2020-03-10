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

    public void insert(ValueNode value) { // responsible for inserting values into the list in sorted order
        if (this.first == null) { //if the row is empty, set the first equal to the valuenode being inserted
            this.first = value;
        }
        else if (this.first.getRow() < value.getRow()) { //if the col of the value being inserted is less than the col of the first, put the val in before
            ValueNode temp = this.first;
            this.first = value;
            this.first.setNextRow(temp);
        }
        else if (this.first.getRow() > value.getRow()) { //else insert it in the correct spot
            ValueNode temp = this.first;
            ValueNode temp2;
            while (value.getRow() > temp.getRow() && temp.getNextRow() != null) {
                temp = temp.getNextRow();
            }
            if (temp.getNextRow() != null) {
                temp2 = temp.getNextRow();
                temp.setNextRow(value);
                temp = temp.getNextRow();
                temp.setNextRow(temp2);
            }
            else {
                temp.setNextRow(value);
            }
        }
    
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