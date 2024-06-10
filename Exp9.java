import java.util.*;

import java.util.Scanner;

public class Exp9 {
    static final int size = 5;
    static int[] s = new int[size];
    static int top = -1;

    public static boolean isFull() {
        return top >= size - 1;
    }

    public static void push(int item) {
        top++;
        s[top] = item;
    }

    public static boolean isEmpty() {
        return top == -1;
    }

    public static int pop() {
        int item = s[top];
        top--;
        return item;
    }

    public static void display() {
        if (isEmpty()) {
            System.out.println("Stack Is Empty!");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(s[i]);
            }
        }
    }

    public static void main(String[] args) {
        int item, choice;
        char ans;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\tImplementation Of Stack");
        do {
            System.out.println("\nMain Menu");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter The item to be pushed: ");
                    item = scanner.nextInt();
                    if (isFull()) {
                        System.out.println("\nStack is Full!");
                    } else {
                        push(item);
                    }
                    break;
                case 2:
                    if (isEmpty()) {
                        System.out.println("\nEmpty stack! Underflow !!");
                    } else {
                        item = pop();
                        System.out.println("\nThe popped element is " + item);
                    }
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.exit(0);
            }
            System.out.print("\nDo You want To Continue? (Y/N): ");
            ans = scanner.next().charAt(0);
        } while (ans == 'Y' || ans == 'y');
    }
}

/*
 
        Implementation Of Stack

Main Menu
1. Push
2. Pop
3. Display
4. Exit
Enter Your Choice: 1

Enter The item to be pushed: 1

Do You want To Continue? (Y/N): y

Main Menu
1. Push
2. Pop
3. Display
4. Exit
Enter Your Choice: 2

The popped element is 1

Do You want To Continue? (Y/N): 4
 */
