public class MyDeque{

    private int size;
    private int first, last;
    private E[] deque;

    public MyDeque(){
	size = 0;
	deque = new E[10]; 
    }

    private void resize(){
	if (deque.length == size){
	    E[] medium = new E[size];
	    System.arraycopy(deque, first, medium, 0, size);
	    E[] newdeque = new E[size * 2];
	    System.arraycopy(medium, first, newdeque, 0, size);
	    deque = newdeque;
	    last -= first;
	    first = 0;
	}
    }

    public MyDeque(int Cap){
	if (Cap < 0) throw new IllegalArgumentException();
	else size = 0;
	deque = new E[Cap]; 
    }

    private void checkerror(E e){
	if (e == null) throw new NullPointerException(); 
    }

    public void addFirst(E e){
	checkerror(e);
	resize();
	size ++;
	if (size = 0){
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
	if (size = 0){
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
	    first = null;
	    last = null;
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
	    last = null;
	    first = null;
	}
	else {
	    deque[last] = null;
	    last -= 1;
	    if (last < 0) last += deque.length;
	}
    }

    public E getFirst(){
	checkerror();
	return deque[first];
    }

    public E getLast(){
	checkerror();
	return deque[last];
    }
    
}
