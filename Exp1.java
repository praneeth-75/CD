
import java.util.*; 
public class Exp1 
{ 
public static void main(String args[]) 
{ 
Scanner sc = new Scanner(System.in); 
System.out.println("Enter the string : "); 
String str=sc.next(); 
int q=0,prev_q; 
System.out.println("Initial state : "+q); 
for(int i=0;i<str.length();i++) 
{ 
if(str.charAt(i)!='a' && str.charAt(i)!='b' && str.charAt(i)!='c'){ 
System.out.println("Given String is invalid"); 
return; 
} 
prev_q=q; 
switch(q) 
{ 
case 0 : q=(str.charAt(i)=='a' )?1:0;break; 
case 1 : q=(str.charAt(i)=='b')?2:(str.charAt(i)=='a')?1:0;break; 
case 2 : q=(str.charAt(i)=='c')?3:(str.charAt(i)=='a')?1:0;break; 
case 3 : q=(str.charAt(i)=='a')?1:0;break; } 
System.out.println("Transition : q"+prev_q+" -> q"+q+"(Input : "+str.charAt(i)+")"); 
} 
if(q==3) 
System.out.println("ACCEPTED"); 
else 
System.out.println("NOT ACCEPTED"); 
} 
} 
