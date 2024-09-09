package algorithm.ch01;

public class Max3Method {
	static int max3(int a, int b, int c) {
		int max = a;
		if(max < b) max = b;
		if(max < c) max = c;
		return max;
	}
	
	static int max4(int a, int b, int c, int d) {
		int max = a;
		if(max < b) max = b;
		if(max < c) max = c;
		if(max < d) max = d;
		return max;
	}
	
	static int min3(int a, int b, int c, int d) {
		int min = a;
		if(min > b) min = b;
		if(min > c) min = c;
		if(min > d) min = d;
		return min;
	}
}
