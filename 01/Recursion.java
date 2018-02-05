public class Recursion{

    public int fact(int n){
	if (n < 0) throw new IllegalArgumentException();
	if (n == 0) return 1;
	return n * fact(n - 1);
    }

    public int fib(int n){
	if (n < 0) throw new IllegalArgumentException();
	if (n == 0 || n == 1) return n;
	int n1 = 0;
	int n2 = 1;
	int f = 0;
	for (int i = 1; i < n; i ++){
	    f = n1 + n2;
	    n1 = n2;
	    n2 = f;
	}
	return f;
    }

    public double sqrt(double n){
	if (n < 0) throw new IllegalArgumentException();
	if (n == 0 || n == 1) return n;
	double g = 1;
	while (Math.abs((g * g) - n) / n > .001){
	    g = findSq(n, g);
	}
	return g;
    }

    private double findSq(double n, double g){
	return (n / g + g) / 2;
    }

}
