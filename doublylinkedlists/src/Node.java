public class Node {
    public Object data;
    public Node next;
    public Node previous;

    public Node(Object data){
        this(null, null, data);
    }

    public Node(Node next, Node previous, Object data){
        this.next = next;
        this.previous = previous;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public Object getData() {
        return data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
