import java.util.LinkedList;

public class Calculator{

    public static double eval(String string){
	LinkedList<Double> stack = new LinkedList<>();
	String current = "";
	for (int i = 0; i < string.length(); i ++){
	    if (string.charAt(i) == ' '){
		if(isOp(current.charAt(0))) stack.push(solve(stack.pop(), stack.pop(), current.charAt(0)));
		else if (isNum(current)) stack.push(Double.parseDouble(current));
		current = "";
	    }
	    else {
		current += string.charAt(i);
	    }
	}
	return solve(stack.pop(), stack.pop(), current.charAt(0));
    }

    private static boolean isOp(char operation){
	if (operation == '+' || operation == '-' || operation == '*' || operation == '/' || operation == '%') return true;
	return false;
    }

    private static boolean isNum(String num){
	try{
	    Double.parseDouble(num);
	}catch(NumberFormatException e){
	    return false;
	}
	return true;
    }

    private static double solve(double num2, double num1, char operation){
	if (operation == '+') return num1 + num2;
	if (operation == '-') return num1 - num2;
	if (operation == '*') return num1 * num2;
	if (operation == '/') return num1 / num2;
        else return num1 % num2;
    }

    public static void main (String args[]){
	System.out.println(eval("6 6 +"));
	System.out.println(eval("11 3 - 4 + 2.5 *"));
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
    
}
