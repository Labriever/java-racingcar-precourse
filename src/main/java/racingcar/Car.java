package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    // 추가 기능 구현
    
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
    	for(int i=0;i<position;i++) {
    		printing.append("-");
    	}
    	String result = printing.toString();
    	return result;
    }
    
//    자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

//    우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

//    사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    
}
