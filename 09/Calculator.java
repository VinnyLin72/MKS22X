import java.util.LinkedList;

public class Calculator{

    public static double eval(String string){
	LinkedList<Double> stack = new LinkedList<>();
	String current = "";
	if (string.length() <= 3) return  Double.parseDouble(string);
	for (int i = 0; i < string.length(); i ++){
	    if (string.charAt(i) == ' '){
		if(isOp(current.charAt(0))) stack.push(solve(stack, current));
		else if (isNum(current)) stack.push(Double.parseDouble(current));
		current = "";
	    }
	    else {
		current += string.charAt(i);
	    }
	}
	return solve(stack, current);
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

    private static double solve(LinkedList<Double> stack, String operation){
	if (operation.length() == 0) return stack.pop();
	else {
	    char op = operation.charAt(0);
	    double num1 = stack.pop();
	    double num2 = stack.pop();
	    if (op == '+') return num2 + num1;
	    if (op == '-') return num2 - num1;
	    if (op == '*') return num2 * num1;
	    if (op == '/') return num2 / num1;
	    else return num2 % num1;
	}
    }

   public static void main(String[] args) {
    System.out.println(eval("6 6 +"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("6 "));
    System.out.println(eval("-6 "));
    System.out.println(eval("-6"));
    System.out.println(eval("6"));
}
    
}
