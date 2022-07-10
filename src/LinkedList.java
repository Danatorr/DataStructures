public class LinkedList {

    //First node of the list
    private Node first = null;
    private int totalElements = 0;

    //As the name implies, it adds at the start of the list
    public void addAtStart (Object data){
        Node newNode = new Node(data, first);
        this.first = newNode;

        this.totalElements++;
    }
    //Adds at the end of the list
    public void add (Object data) { }
    //Adds at a specific position
    public void add (int position, Object data) {}
    //Gets the data stored in specific position
    public Object get(int position) { return null; }
    //Removes an node
    public void remove (int position) { }
    public int size() {return 0; }
    //Checks if it contains the specified data
    public boolean contains(Object object) { return false; }

    //Additional methods for better visualisation


    @Override
    public String toString() {
        if (this.totalElements == 0){
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
