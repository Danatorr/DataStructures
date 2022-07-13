public class DoublyLinkedListsTestClass {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addAtStart("Torres");
        System.out.println(list);
        list.addAtStart("Daniel");
        System.out.println(list);
        list.add("Test");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
