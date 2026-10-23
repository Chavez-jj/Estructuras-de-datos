package co.edu.uniquindio.poo.pilas;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stackA = new Stack<>();
        stackA.push(4); // pushed first, so it ends at the bottom
        stackA.push(3);
        stackA.push(5); // top

        Stack<Integer> stackB = new Stack<>();
        stackB.push(8);
        stackB.push(7);
        stackB.push(6); // top

        System.out.print("Stack A: ");
        stackA.print();
        System.out.print("Stack B: ");
        stackB.print();

        stackA.concatenate(stackB);

        System.out.print("A after concatenate: ");
        stackA.print();
        System.out.print("B after concatenate: ");
        stackB.print();
        System.out.println("Size of A: " + stackA.getSize());
    }
}
