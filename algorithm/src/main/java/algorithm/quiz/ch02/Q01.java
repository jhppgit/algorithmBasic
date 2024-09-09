package algorithm.quiz.ch02;

import java.util.Random;

// 키와 사람 수를 난수로 생성
public class Q01 {
	static int maxOf(int[] height) {
		int max = height[0];
		for(int i = 1; i < height.length; i++) {
			if (max < height[i])
				max = height[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(15);
		int[] height = new int[num];
		
		System.out.println(num + "명의 킷값");
		for (int i = 0; i < num; i++) {
			height[i] = rand.nextInt(100) + 100;
			System.out.println("height[" + i + "] : " + height[i]);
		}
		System.out.println("최댓값: " + maxOf(height));
	}
}
