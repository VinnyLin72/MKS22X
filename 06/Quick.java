import java.util.*;
import java.io.*;

public class Quick {

    public static void quicksort(int[] ary){
	if (a.length >= 2) {
	    QuickSortH(ary, 0, ary.length - 1);
	}
    }

    public static int quickselect(int[] ary, int k){
	int start = 0;
	int end = ary.length-1;
	int i = partition(ary, start, end);
	while(i != k){
	    if (i < k){
		start = i+1;
		i = partition(ary, start, end);
	    }
	    else {
		end = i-1;
                i = partition(ary, start, end);
	    }
	    i = partition(ary,start,end);	
	}
		 
	return data[i];
    }
    private static void swap(int[] ary,int a, int b) {
	int c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }
    
    public static void QuickSortH(int[] a, int start, int end){
	if(start<end) {
	    int x = partition(a,start,end);
	    QuickSortH(a,start,x-1);
	    QuickSortH(a,x+1,end);
	}
    }

    private static int partition(int[] ary,int start,int end){
	if (ary.length < 2){
	    return start;
	}
	int s = start;
	int pi = (int) (Math.random()*(end-start+1));
	pi += start;
	int pv = ary[pi];
	swap(ary,pi,end);
	while (start < end+1){
	    if(data[start]<pv){
		swap(ary,start,s);
		s++;
	    }
	    start++;
	}
	swap(ary,s,end);
	return s;
    }
