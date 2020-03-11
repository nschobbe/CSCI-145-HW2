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
            System.out.println(value + " this is the value row 1");
            this.first = value;
        }
        else if (this.first.getColumn() < value.getColumn()) { //if the col of the value being inserted is less than the col of the first, put the val in before
            ValueNode temp = this.first;
            System.out.println(value + " this is the value row 2");
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
                System.out.println(value + " this is the value row 3");
                temp.setNextColumn(value);
                temp = temp.getNextColumn();
                System.out.println(value + " this is the value row 4");
                temp.setNextColumn(temp2);
            }
            else {
                System.out.println(value + " this is the value row 5");
                temp.setNextColumn(value);
            }
        }
    }

    public int get(int position) {
        ValueNode temp = first;

        try {
            int value;

            while(temp != null && temp.getColumn() < position){
                temp = temp.getNextColumn();
            }
            if(temp == null){
                value = -1;
            }
            if (temp.getColumn() != position) {
                value = 0;
            }
            else{
                value = temp.getValue();
            }
            return value;
        } catch(Exception e){
            //System.out.println(e);
        }
        return -1;



    }

}