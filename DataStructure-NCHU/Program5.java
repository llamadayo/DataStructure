/**
 * Using stack to transfer Infix to Postfix
 */


import java.util.Scanner;
import java.util.Stack;

public class Program5
{
    public static void main (String[] argv)
    {
        Scanner input = new Scanner(System.in);
        String answer;
        String origin = input.next();
        while(!check_parenthesis(origin))
        {
            System.out.println("Please Enter Again:");
            origin = input.next();
        }
        answer = ToPostfix(origin);
        System.out.println("--------------------\nPostfix: "+answer);
        System.out.println("--------------------\ncalculate number: " + evaluate(answer));
        System.out.println();
    }


    public static boolean check_parenthesis(String origin)
    {
        Stack<String> st = new Stack<String>();
        for(int i = 0; i<origin.length(); i++)
        {
            if(origin.charAt(i) == '(')
            {
                st.push(Character.toString(origin.charAt(i)));
            }
            else if(origin.charAt(i) == ')')
            {
                if(st.empty())
                {
                    System.out.println("Closing parethesis not matched.");
                    return false;
                }
                else
                {
                    st.pop();
                }
            }
        }
        if(!st.empty())
        {
            System.out.println("Opening parethesis not matched.");
            return false;
        }
        return true;
    }


    public static String ToPostfix(String origin)
    {
        Stack<String> st1 = new Stack<String>();
        String post = "";
        String operation_st ="";
        int len = origin.length();
        String temp;
        for(int i = 0; i< len ; i++ )
        {
            if(origin.charAt(i) == '(')
            {
                 st1.push(Character.toString(origin.charAt(i)));
                 operation_st += Character.toString(origin.charAt(i));
                 operation_st += " ";
            }
            else if(origin.charAt(i) == ')')
            {
                temp = st1.pop();
                operation_st = operation_st.substring(0,operation_st.lastIndexOf(" ")-1);
                while(temp.charAt(0) != '(')
                {
                    post += temp;
                    temp = st1.pop();
                    operation_st = operation_st.substring(0,operation_st.lastIndexOf(" ")-1);
                }
            }
            else if(origin.charAt(i) == '+' || origin.charAt(i) == '-' || origin.charAt(i) == '*' || origin.charAt(i) == '/')
            {
                if(!st1.empty())
                {
                    temp = st1.peek();
                    while( !st1.empty() &&  new_has_low_priority(Character.toString(origin.charAt(i)), temp))
                    {
                        temp = st1.pop();
                        operation_st = operation_st.substring(0,operation_st.lastIndexOf(" ")-1);
                        post += temp;
                        if(!st1.empty()) temp = st1.peek();
                    }
                }
                st1.push(Character.toString(origin.charAt(i)));
                operation_st += Character.toString(origin.charAt(i));
                operation_st += " ";
            }
            else
            {
                post += Character.toString( origin.charAt(i));
            }
        }
        while(!st1.empty())
        {
            temp = st1.pop();
            operation_st = operation_st.substring(0,operation_st.lastIndexOf(" ")-1);
            post += temp;
        }
        return post;
    }

    public static boolean new_has_low_priority(String newData , String topData)
    {
        int newprio = 0;
        int topprio = 0;
        switch (topData)
        {
            case "(":
            case ")":
                topprio = 0;
                break;
            case "+":
            case "-":
                topprio = 1;
                break;
            case "*":
            case "/":
                topprio = 2;
                break;
            default:
                return false;
        }
        switch (newData)
        {
            case "(":
            case ")":
                newprio = 100;
                break;
            case "+":
            case "-":
                newprio = 1;
                break;
            case "*":
            case "/":
                newprio = 2;
                break;
            default:
                return false;
        }
        if(newprio <= topprio)
            return true;
        else
            return false;
    }

    public static String calculate(String num2,String num1,String operator)
    {
        int result = 0;
        int n1 = Integer.parseInt(num2);
        int n2 = Integer.parseInt(num1);
        switch(operator)
        {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
            default:
                System.out.println("error");
        }
        return Integer.toString(result);
    }

    public static String evaluate(String post)
    {
        Stack<String> st2 = new Stack<String>();
        String result ="";
        int i;
        String num1,num2,operator;
        for(i = 0; i < post.length() ;i++)
        {
            if(post.charAt(i) == '+' || post.charAt(i) == '-' || post.charAt(i) == '*' || post.charAt(i) == '/')
            {
                num1 = st2.pop();
                num2 = st2.pop();
                operator = Character.toString( post.charAt(i));
                result = calculate(num2,num1,operator);
                st2.push(result);
            }
            else
            {
                st2.push(Character.toString( post.charAt(i)));
            }
        }
        return result;
    }

}
