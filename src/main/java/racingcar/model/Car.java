package racingcar.model;

import java.util.InputMismatchException;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.CheckError;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}
	public Car() {
		this.name = "";
		// TODO Auto-generated constructor stub
	}
	
//    주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
//    전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
	public void start() {
		Scanner sc = new Scanner(System.in);
    	CheckError ce = new CheckError();
    	
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    	String names = sc.nextLine();
    	while (true) {
            try {
                ce.isName(names); // 이름 검사 메소드 호출
                break; // 예외가 발생하지 않으면 반복문 탈출
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            	names = sc.next(); // 다시 입력 받음
            }
        }
		
    	String[] nameArr = names.split(",");
    	Car[] car = new Car[nameArr.length];
    	int[] movingCount = new int[nameArr.length];
    	
    	for(int i=0;i<nameArr.length;i++) {
    		car[i] = new Car(nameArr[i]);
    	}
    	
//      사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
		System.out.println("시도할 회수는 몇회인가요?");
		int count = sc.nextInt();
		while (true) {
            try {
                ce.isCount(count); // 이름 검사 메소드 호출
                break; // 예외가 발생하지 않으면 반복문 탈출
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
                System.out.println("시도할 회수는 몇회인가요?");
                count = sc.nextInt(); // 다시 입력 받음
            }
        }
		
//      자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    	int max = 0;
		for(int j=0;j<count;j++) {
    		for(int i=0;i<nameArr.length;i++) {
    			movingCount[i] = car[i].move();
    			max = Math.max(max, movingCount[i]);
    		}
    		System.out.println();
    	}
		
		getWinner(movingCount, nameArr, max);
		
	}
	
	
	public static void getWinner(int[] movingCount, String[] nameArr, int max) {
		//      우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    	StringBuilder sb = new StringBuilder();
    	sb.append("최종 우승자 : ");
		for(int i=0;i<nameArr.length;i++) {
    		if(movingCount[i] == max) {
    			sb.append(nameArr[i]+",");
    		}
    	}
		System.out.println(sb.substring(0, sb.length()-1));
	}
	
	public int move() {
		int num = Randoms.pickNumberInRange(0, 9);
		if (num >= 4) {
			position++;
		}
		print();
		return position;
	}

//    각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
	public void print() {
		StringBuilder printing = new StringBuilder();
		printing.append(name + " : ");
		for (int i = 0; i < position; i++) {
			printing.append("-");
		}
		String result = printing.toString();
		System.out.println(result);
	}



}
