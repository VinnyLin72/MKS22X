import java.util.*;
import java.io.*;

public class Merge {
	
    public static void mergesort(int[] data) {
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length - 1);
    }

    public static void msort(int[] data, int[] temp, int lo, int hi) {
	if (lo < hi){
	    for (int i = lo; i < hi + 1; i ++){
		temp[i] = data[i];
	    }
	    msort(temp, data, lo, (lo + hi) / 2);
	    msort(temp, data, (lo + hi) / 2 + 1, hi);
	    merge(data, temp, lo, (lo + hi) / 2, (lo + hi) / 2 + 1, hi);
	}
    }

    public static void merge(int[] data, int[] temp, int lo, int hi, int lo1, int hi1) {
	for (int i = lo; i < hi1 + 1; i ++){
	    if (lo < hi + 1 && (lo1 > hi1 || temp[lo] < temp[lo1])){
		data[i] = temp[lo];
		lo ++;
	    }
	    else {
		data[i] = temp[lo1];
		lo1 ++;
	    }
	}
    }
 
}
