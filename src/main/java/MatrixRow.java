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
        if (this.first == null) { //if the row is empty, set the first equal to the valuenode being inserted
            this.first = value;
        }
        else if (this.first.getColumn() < value.getColumn()) { //if the col of the value being inserted is less than the col of the first, put the val in before
            ValueNode temp = this.first;
            this.first = value;
            this.first.setNextColumn(temp);
        }
        else if (this.first.getColumn() > value.getColumn()) { //else insert it in the correct spot
            ValueNode temp = this.first;
            ValueNode temp2;
            while (value.getColumn() > temp.getColumn() && temp.getNextColumn() != null) {
                temp = temp.getNextColumn();
            }
            if (temp.getNextColumn() != null) {
                temp2 = temp.getNextColumn();
                temp.setNextColumn(value);
                temp = temp.getNextColumn();
                temp.setNextColumn(temp2);
            }
            else {
                temp.setNextColumn(value);
            }
        }
    }

    public int get(int position) {
        ValueNode temp = first;
        int value;

        if (this.first == null) {
            return -1;
        }
        while (position > temp.getColumn()) {
            System.out.println("Position: " + position + ", Current Column " + temp.getColumn());
            temp = temp.getNextColumn();
        }
        if (temp == null) {
            return 0;
        }
        else {
            return temp.getValue();
        }

    }

}