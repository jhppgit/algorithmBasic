package algorithm.quiz.ch04;

import java.util.Scanner;

import algorithm.ch04.IntStack;

// IntStack의 모든 메서드를 사용하는 프로그램 작성
public class Q1 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while (true) {
			System.out.println();
			System.out.printf("현재 데이터의 개수 : %d / %d%n", s.size(), s.getCapacity());
			System.out.print("(1) 푸시  (2) 팝  (3) 피크  (4) 덤프  (5) 검색  (6) 클리어  (0) 종료 : ");
			
			int menu = stdIn.nextInt();
			int x;
			switch(menu) {
			case 1: // push
				if (s.isFull()) {
					System.out.println("스택이 가득 찼습니다.");
				} else {
					System.out.print("데이터 : ");
					x = stdIn.nextInt();
					s.push(x);
				} 
				break;
				
			case 2: // pop
				if (s.isEmpty())
					System.out.println("스택이 비었습니다.");
				else {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + " 입니다.");
				}
				break;
				
			case 3: // peek
				if (s.isEmpty())
					System.out.println("스택이 비었습니다");
				else {
					x = s.peek();
					System.out.println("피크한 데이터는 + " + x + "입니다.");
				}
				break;
				
			case 4: // dump
				if (s.isEmpty())
					System.out.println("스택이 비었습니다");
				else 
					s.dump();
				break;
				
			case 5: // indexOf
				if (s.isEmpty())
					System.out.println("스택이 비었습니다");
				else {
					System.out.print("검색할 정수를 입력하세요");
					x = stdIn.nextInt();
					int idx = s.indexOf(x);
					if (idx == -1) 
						System.out.println("스택에 해당 데이터가 존재하지 않습니다");
					else 
						System.out.println(x + "는 s[" + idx + "]에 존재합니다");
				}
				break;
			case 6: // clear
				System.out.print("스택을 비우려면 1을 입력하세요. 원하지 않으면 다른 숫자를 입력하세요.");
				x = stdIn.nextInt();
				if (x == 1)
					s.clear();
				break;
			}
			
		}
	}
}
