public class RunningMedian{
    
    private MyHeap<Double> minHeap;
    private MyHeap<Double> maxHeap;

    @SuppressWarnings("unchecked")
    public RunningMedian(double[] a){
	minHeap = new MyHeap<>();
	maxHeap = new MyHeap<>(false);
	for(int i = 0; i < a.length; i++){
	    add(a[i]);
	}
    }

    public Double getMedian(){
	Double ans = 0.0;
	int nums = 0;
	if(minHeap.size() >= maxHeap.size()){
	    ans+= minHeap.peek();
	    nums++;
	}
	if(maxHeap.size() >= minHeap.size()){
	    ans+= maxHeap.peek();
	    nums++;
	}
	return ans / nums;
    }

    public void add(Double a){
	if(minHeap.size() == 0 && maxHeap.size() == 0){
	    minHeap.add(a);
	}
	else{
	    if(a > minHeap.peek()){
		maxHeap.add(a);
		if(maxHeap.size() - minHeap.size() == 2){
		    minHeap.add(maxHeap.remove());
		}
	    }
	    else{
		minHeap.add(a);
		if(minHeap.size() - maxHeap.size() == 2){
		    maxHeap.add(minHeap.remove());
		}
	    }
	}
    }

}
