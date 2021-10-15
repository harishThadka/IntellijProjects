package collectionPackage.listPackage;

import java.util.List;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {

        Stack<String> stacks = new Stack<>();

        stacks.push("stack1");
        stacks.push("stack2");
        stacks.push("stack3");
        stacks.push("stack4");

        System.out.println(stacks);

        System.out.println(stacks.pop());// Removing the top element

        System.out.println(stacks.peek());// Returns the top

        System.out.println(stacks + " "+stacks.size());

        // Search the element and returns the index which starts from 1
        System.out.println(stacks.search("stack2"));

        System.out.println(stacks.get(2));




    }
}
