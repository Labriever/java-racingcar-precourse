package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
    	Scanner sc = new Scanner(System.in);
//      자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    	String names = sc.next();
    	String[] nameArr = names.split(",");
    	
    	
//      사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
//      자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
        
//      우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

//      사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    	
    }
}
