package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void isName(String names) {
//      자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] nameArr = names.split(",");
		if (nameArr.length > 5) {
			throw new IllegalArgumentException(printError(1));
		} else {
			for (int i = 0; i < nameArr.length; i++) {
				if(nameArr[i].length()>5 || nameArr[i].length() == 0) {
					throw new IllegalArgumentException(printError(2));
				}
			}
		}

	}

//    주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
//    전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
	public int move() {
		int num = Randoms.pickNumberInRange(0, 9);
		if (num >= 4) {
			position++;
		}
		return position;
	}

//    각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
	public String print() {
		StringBuilder printing = new StringBuilder();
		printing.append(name + " : ");
		for (int i = 0; i < position; i++) {
			printing.append("-");
		}
		String result = printing.toString();
		return result;
	}

	public static String printError(int errorType) {
		String error = "[ERROR]";
		if (errorType == 1) { // name이 5개 초과
			error += "최대 5명까지 입력 가능합니다.";
		} else if (errorType == 2) { // name이 5자 초과
			error += "이름은 5자 미만으로 설정해주세요";
		} else if (errorType == 3) { // 이동 값 잘못 정함
			error += "이동할 값을 잘못 입력하셨습니다.";
		}
		return error;
	}

}
