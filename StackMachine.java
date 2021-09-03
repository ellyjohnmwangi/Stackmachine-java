import java.util.Scanner;
import java.util.Stack;

public class StackMachine {
    public static void  main(String[] args){
        System.out.println("Enter operations here: ");
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        // split string with white space
        String[] stringParts=S.split("\\s");

        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<stringParts.length;i++) {
            Integer in;
            switch (stringParts[i])
            {
                case "DUP":
                    if(stack.isEmpty()) System.out.println("-1") ;
                    stack.push(stack.peek());
                    break;
                case "POP":
                    if(stack.isEmpty()) System.out.println("-1");
                    stack.pop();
                    break;
                case "+":
                    if(stack.size() < 1)System.out.println("-1") ;
                    in= 0;
                    in+=stack.pop();
                    in+=stack.pop();
                    stack.push(in);
                    break;
                case "-":
                    if(stack.size() < 1) System.out.println("-1") ;
                    in=stack.pop();
                    in-=stack.pop();
                    stack.push(in);
                    break;
                default:
                    stack.push(Integer.parseInt(stringParts[i]));
                    break;
            }
        }

        //last check
        if(stack.size() < 1) System.out.println("-1") ;
        else System.out.println(stack.pop());
    }
}
