import java.util.ArrayList;

public class Exp10 {
    private static int i = 1, j = 0, no = 0, tmpch = 90;
    private static String str = "";
    private static String left = "", right = "";
    private static ArrayList<Exp> k = new ArrayList<>();

    private static class Exp {
        int pos;
        char op;
    }

    public static void main(String[] args) {
        System.out.println("\t\tIntermediate code generation");
        System.out.print("Enter the expression: ");
        str = System.console().readLine();
        System.out.println("The Intermediate code:\t\t Expression");
        findopr();
        explore();
    }

    private static void findopr() {
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ':') {
                Exp e = new Exp();
                e.pos = i;
                e.op = ':';
                k.add(e);
                j++;
            } else if (str.charAt(i) == '/') {
                Exp e = new Exp();
                e.pos = i;
                e.op = '/';
                k.add(e);
                j++;
            } else if (str.charAt(i) == '*') {
                Exp e = new Exp();
                e.pos = i;
                e.op = '*';
                k.add(e);
                j++;
            } else if (str.charAt(i) == '+') {
                Exp e = new Exp();
                e.pos = i;
                e.op = '+';
                k.add(e);
                j++;
            } else if (str.charAt(i) == '-') {
                Exp e = new Exp();
                e.pos = i;
                e.op = '-';
                k.add(e);
                j++;
            }
        }
    }

    private static void explore() {
        i = 1;
        while (i < k.size() && k.get(i).op != '\0') {
            fleft(k.get(i).pos);
            fright(k.get(i).pos);
            str = str.substring(0, k.get(i).pos) + (char) tmpch-- + str.substring(k.get(i).pos + 1);
            System.out.printf("\t %c:=%s%c%s\t\t", str.charAt(k.get(i).pos), left, k.get(i).op, right);
            for (int x = 0; x < str.length(); x++) {
                if (str.charAt(x) != '$') {
                    System.out.print(str.charAt(x));
                }
            }
            System.out.println();
            i++;
        }
        fright(-1);
        if (no == 0) {
            fleft(str.length());
            System.out.printf("\t %s:=%s", right, left);
        }
        System.out.printf("\t %s:=%c", right, str.charAt(k.get(--i).pos));
    }

    private static void fleft(int x) {
        int w = 0;
        boolean flag = false;
        x--;
        while (x != -1 && str.charAt(x) != '+' && str.charAt(x) != '*' && str.charAt(x) != '=' && str.charAt(x) != '\0' && str.charAt(x) != '-' && str.charAt(x) != '/' && str.charAt(x) != ':') {
            if (str.charAt(x) != '$' && !flag) {
                left = str.charAt(x) + left;
                str = str.substring(0, x) + "$" + str.substring(x + 1);
                flag = true;
            }
            x--;

        }
    }

    private static void fright(int x) {
        int w = 0;
        boolean flag = false;
        x++;
        while (x != -1 && x < str.length() && str.charAt(x) != '+' && str.charAt(x) != '*' && str.charAt(x) != '=' && str.charAt(x) != '\0' && str.charAt(x) != '-' && str.charAt(x) != '/' && str.charAt(x) != ':') {
            if (str.charAt(x) != '$' && !flag) {
                right += str.charAt(x);
                str = str.substring(0, x) + "$" + str.substring(x + 1);
                flag = true;
            }
            x++;
        }
    }
}

/*
                 Intermediate code generation
Enter the expression: a*b+c/d-e/f+g*
The Intermediate code:           Expression
         Z:=b+c         a*Z/d-e/f+g*
         Y:=Zb/cd               a*Y-e/f+g*
         X:=YZb-cde             a*X/f+g*
         W:=XYZb/cdef           a*W+g*
         V:=WXYZb+cdefg         a*V*
         U:=VWXYZb*cdefg                a*U
         cdefga:=UVWXYZb         cdefga:=$
 */
