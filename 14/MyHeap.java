public class MyHeap <T extends Comparable<T>>{
    
    private int length;
    private T[] data;
    private boolean Max;

    public MyHeap(){
	this(true);
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean max){
	if (max) Max = true;
	else Max = false;
	data = (T[])new Comparable[10];
	length = 0;
    }

    public int size(){
	return length;
    }

    public T peek(){
	return data[0];
    }

    public void pushUp(int index){
	int parent = (index-1)/2;
	if (Max && data[index].compareTo(data[parent]) > 0 ||
	    !Max && data[index].compareTo(data[parent]) < 0){
	    swap(index, parent);	    
	    pushUp(parent);
	}
    }

    public void pushDown(int index){
	int L = index*2+1;
	int R = index*2+2;
	if (Max && L < size()&& data[index].compareTo(data[L]) < 0
	    && (R >= size() || data[R].compareTo(data[L]) <= 0)
	    || !Max && L < size()&& data[index].compareTo(data[L]) > 0
	    && (R >= size() || data[R].compareTo(data[L]) >= 0)){
	    swap(index, L);	    
	    pushDown(L);	   
	}
	else if (Max && R < size() && data[index].compareTo(data[R]) < 0
		 && (L >= size() || data[L].compareTo(data[R]) <= 0)
		 || !Max && R < size()&& data[index].compareTo(data[R]) > 0
		 && (L >= size() || data[L].compareTo(data[R]) >= 0)){
	    swap(index, R);
	    pushDown(R);			     	    
	}
    }

    public void add(T s){
	if (size() == data.length){
	    resize();
	}
	data[size()] = s;	
	pushUp(size());
	length++;	
    }

    public T remove(){
	T s = peek();
	swap(0, size() - 1);
	length --;	
	pushDown(0);	
	return s;
    } 

    public void swap (int n, int m){
	T temp = data[n];
	data[n] = data[m];
	data[m] = temp;
    }

    public String toString(){
	String str = "";
	for (int i = 0; i < size(); i++){
	    str += data[i] + "  ";
	}
	return str;
    }
    
    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp = (T[])new Comparable[size() * 2];
	for (int i = 0; i < size(); i++){
	    temp[i] = data[i];
	}
        data = temp;	
    }
    
}
