public class StackTestClass {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println(stack.empty());
        stack.add("Daniel");
        System.out.println(stack);
        stack.add("Daniel 2");
        System.out.println(stack);
        System.out.println(stack.empty());
    }
}
