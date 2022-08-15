import java.util.LinkedList;
import java.util.List;

public class Stack {

    private List<Object> storedData = new LinkedList<Object>();
    private int totalElements = 0;
    private Node first = null;
    private Node last = null;

    public void insert(Object data) {
        storedData.add(data);
    }

    public void addAtStart(Object data){
        if(this.totalElements == 0){
            // Using one of the two constructors
            Node newNode = new Node(data);
            this.first = newNode;
            this.last = newNode;
        } else {
            // Using the second of the two constructors
            Node newNode = new Node(first, null, data);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }

        this.totalElements++;
    }

    public void add(Object data){
        if(this.totalElements == 0){
            addAtStart(data);
        } else {
            Node newNode = new Node(null, this.last, data);
            this.last.setNext(newNode);
            this.last = newNode;

            this.totalElements++;
        }
    }

    public Object remove() {
        return storedData.remove(storedData.size() - 1);
    }

    public void removeFromStart(){
        if(this.totalElements == 0){
            throw new IllegalArgumentException("The list is already empty!");
        }

        this.first = this.first.getNext();
        this.totalElements--;

        if(this.totalElements == 0){
            this.last = null;
        }
    }

    public void removeFromEnd(){
        if(this.totalElements == 1){
            this.removeFromStart();
        } else {
            /*
             * Node penultimate = this.last.getPrevious();
             * penultimate.setNext(null);
             * this.last = penultimate;
             * this.totalElements--;
             */

            this.last = this.last.getPrevious();
            this.last.setNext(null);
            this.totalElements--;
        }
    }

    public boolean empty() {
        //return storedData.isEmpty();
        //return storedData.size() == 0;
        if (totalElements == 0){
            return true;
        }
        return false;
    }

    public String toString() {
        if(this.totalElements == 0){
            return "[]";
        }

        Node currentNode = first;

        StringBuilder builder = new StringBuilder("[");

        for(int i = 0; i < totalElements; i++){
            builder.append(currentNode.getData());
            builder.append(",");

            //Increasing the node "id" by 1
            currentNode = currentNode.getNext();
        }
        builder.append("]");

        return builder.toString();
    }
}
