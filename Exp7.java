import java.util.Scanner;

public class Exp7 {
    static int k = 0, z = 0, i = 0, j = 0, c = 0;
    static char[] a = new char[16];
    static char[] stk = new char[15];
    static String act = "";
    static String ac = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("GRAMMAR is:");
        System.out.println("E->E+E");
        System.out.println("E->E*E");
        System.out.println("E->(E)");
        System.out.println("E->id");
        System.out.println("Enter input string:");
        String input = sc.nextLine();
        a = input.toCharArray();
        c = a.length;
        act = "\tSHIFT->";
        System.out.println("stack\t\tinput\t\t\taction");
        for (k = 0, i = 0, j = 0; j < c; k++, i++, j++) {
            if (a[j] == 'i' && a[j + 1] == 'd') {
                stk[i] = a[j];
                stk[i + 1] = a[j + 1];
                stk[i + 2] = '\0';
                a[j] = ' ';
                a[j + 1] = ' ';
                System.out.println("$" + new String(stk) + "\t\t" + new String(a) + "$\t\t\t" + "id");
                check();
            } else {
                stk[i] = a[j];
                stk[i + 1] = '\0';
                a[j] = ' ';
                System.out.println("$" + new String(stk) + "\t\t" + new String(a) + "$\t\t\tsymbols");
                check();
            }
        }
    }

    static void check() {
        ac = "\t\tREDUCE TO E";
        for (z = 0; z < c; z++) {
            if (stk[z] == 'i' && stk[z + 1] == 'd') {
                stk[z] = 'E';
                stk[z + 1] = '\0';
                break;
            }
        }
        for (z = 0; z < c; z++) {
            if (stk[z] == 'E' && stk[z + 1] == '+' && stk[z + 2] == 'E') {
                stk[z] = 'E';
                stk[z + 1] = '\0';
                stk[z + 2] = '\0';
                i = i - 2;
            }
        }
        for (z = 0; z < c; z++) {
            if (stk[z] == 'E' && stk[z + 1] == '*' && stk[z + 2] == 'E') {
                stk[z] = 'E';
                stk[z + 1] = '\0';
                stk[z + 2] = '\0';
                i = i - 2;
            }
        }
        for (z = 0; z < c; z++) {
            if (stk[z] == '(' && stk[z + 1] == 'E' && stk[z + 2] == ')') {
                stk[z] = 'E';
                stk[z + 1] = '\0';
                stk[z + 2] = '\0';
                i = i - 2;
            }
        }
        System.out.println("$" + new String(stk) + "\t\t" + new String(a) + "$\t\t" + ac);
        j++;
    }
}


