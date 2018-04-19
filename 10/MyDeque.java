public class MyDeque{

    private int size;
    private int first, last;
    private E[] deque;

    public MyDeque(){
	size = 0;
	deque = new E[10]; 
    }

    public MyDeque(int Cap){
	if (Cap < 0) throw new IllegalArgumentException();
	else size = 0;
	deque = new E[Cap]; 
    }

    public void addFirst(E e){
	if (size = 0)
    }

}
