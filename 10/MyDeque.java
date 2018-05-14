import java.util.*;
import java.io.*;

public class MyDeque<E>{

    private int size;
    private int first, last;
    private E[] deque;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	size = 0;
	deque = (E[])new Object[1]; 
    }
    
    @SuppressWarnings("unchecked")
    private void resize(){
	if (size == deque.length){
        E[] newDeque = (E[])new Object[size * 2];
	if(first < last){
	    for (int i = first; i <= last; i++){
	        newDeque[i] = deque[i];
	    }
	}
	else{
	    int in = 0;
	    for(int i = first; i < deque.length; i++){
	        newDeque[in] = deque[i];
		in ++;
	    }
	    for(int i = 0; i <= last; i++){
		newDeque[in] = deque[i];
		in ++;
	    }
	}
	deque = newDeque;
	first = 0;
	last = size - 1;
	}
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int Cap){
	if (Cap < 0) throw new IllegalArgumentException();
	else size = 0;
	deque = (E[])new Object[Cap]; 
    }

    private void checkerror(E e){
	if (e == null) throw new NullPointerException(); 
    }

    public void addFirst(E e){
	checkerror(e);
	resize();
	size ++;
	if (size == 0){
	    deque[0] = e;
	    first = 0;
	    last = 0;
	}
	else {
	    first -= 1;
	    if (first < 0) first += deque.length;
	    deque[first] = e;
	}
    }

    public void addLast(E e){
	checkerror(e);
	resize();
	size ++;
	if (size == 0){
	    deque[0] = e;
	    first = 0;
	    last = 0;
	}
	else {
	    last += 1;
	    if (last >= deque.length) last -= deque.length;
	    deque[last] = e;
	}
    }

    private void checkerror(){
	if (size == 0) throw new NoSuchElementException();
    }

    public E removeFirst(){
	checkerror();
	size --;
	E ans = deque[first];
	if(size == 0){
	    deque[first] = null;
	}
	else {
	    deque[first] = null;
	    first += 1;
	    if (first >= deque.length) first -= deque.length;
	}
	return ans;
    }

    public E removeLast(){
	checkerror();
	size --;
	E ans = deque[last];
	if (size == 0){
	    deque[last] = null;
	}
	else {
	    deque[last] = null;
	    last -= 1;
	    if (last < 0) last += deque.length;
	}
	return ans;
    }

    public E getFirst(){
	checkerror();
	return deque[first];
    }

    public E getLast(){
	checkerror();
	return deque[last];
    }

    public String toString(){
	String ans = "[";
	if(first < last){
	    for (int i = first; i <= last; i++){
		ans += deque[i] + ", ";
	    }
	}
	else{
	    for(int i = first; i < deque.length; i++){
		ans += deque[i] + ", ";
	    }
	    for(int i = 0; i <= last; i++){
		ans += deque[i] + ", ";
	    }
	}
	ans = ans.substring(0, ans.length() - 2) + "]";
	return ans;
    }

    public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = 15;
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 10);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
}
    
}
