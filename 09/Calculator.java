public class Calculator{

    public static double eval(String string){
	
    }

    private static double eHelper(double num1, double num2, char operation){
	if (operation == '+') return num1 + num2;
	if (operation == '-') return num1 - num2;
	if (operation == '*') return num1 * num2;
        else return num1 / num2;
    }

    public static void main (String args[]){
	System.out.println(eHelper(2.0, 3.0, '+'));
    }
    
}
