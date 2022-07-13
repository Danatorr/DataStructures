public class DoublyLinkedList {
    private Node first = null;
    private Node last = null;
    private int totalElements = 0;

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

    public void add(int position, Object data){
        if(position > this.totalElements || position < 0){
            throw new IllegalArgumentException("This position does not exist!");
        } else if(position == this.totalElements){
            this.add(data);
        } else {
            Node previous = getNode(position - 1);
            Node next = previous.getNext();
            Node newNode = new Node(previous.getNext(), previous, data);
            previous.setNext(newNode);
            next.setPrevious(newNode);

            this.totalElements++;
        }
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

    public void remove(int position){
        if(this.totalElements == 1 || position == 0){
            removeFromStart();
        } else if(position == this.totalElements - 1){
            removeFromEnd();
        } else {
            Node previous = getNode(position - 1);
            Node newNext = previous.getNext().getNext();

            if(newNext != null){
                previous.setNext(newNext);
                newNext.setPrevious(previous);
                this.totalElements--;
            } else {
                previous.setNext(newNext);
                this.totalElements--;
            }
        }
    }

    public boolean contains(Object data){
        Node current = this.first;

        while(current != null) {
            if (current.getData().equals(data)) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    public Node getNode (int position){
        if(!positionExists(position)){
            throw new IllegalArgumentException("This position does not exist!");
        }

        Node currentNode = first;

        for (int i = 0; i < position; i++){
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    private boolean positionExists(int position){
        return position >= 0 && position < this.totalElements;
    }

    @Override
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
