public class LinkedList {

    //First node of the list
    private Node first = null;
    private Node last = null;
    private int totalElements = 0;

    //As the name implies, it adds at the start of the list
    public void addAtStart (Object data){
        Node newNode = new Node(data, first);
        this.first = newNode;

        //This sets the first element to be inserted as the last one as well
        if(this.totalElements == 0){
            this.last = this.first;
        }

        this.totalElements++;
    }
    //Adds at the end of the list
    public void add (Object data) {
        if(this.totalElements == 0){
            addAtStart(data);
        } else {

            Node newNode = new Node(data, null);
            //This makes the last existing node point to the newly created one
            this.last.setNext(newNode);
            //Makes the last node be the newest one
            this.last = newNode;

            this.totalElements++;
        }
    }
    //Adds at a specific position
    public void add (int position, Object data) {
        if(position == 0){
            addAtStart(data);
        } else if(position == this.totalElements) {
            add(data);
        } else {
            Node previousNode = this.getNode(position - 1);
            Node newNode = new Node(data, previousNode.getNext());
            previousNode.setNext(newNode);
            this.totalElements++;
        }
    }

    private boolean positionExists(int position){
        return position >= 0 && position < this.totalElements;
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
    //Gets the data stored in specific position
    public Object getData(int position) {
        return this.getNode(position).getData();
    }
    //Removes an node
    public void removeFromStart () {
        if (totalElements == 0){
            throw new IllegalArgumentException("The list is already empty!");
        }

        //Setting the propriety that points to the first node in the list to be the second node
        this.first = this.first.getNext();
        this.totalElements--;

        if(this.totalElements == 0){
            this.last = null;
        }
    }
    public int size() {
        return this.totalElements;
    }
    //Checks if it contains the specified data
    public boolean contains(Object object) { return false; }

    //Additional methods for better visualisation


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
