package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.service.RacingService;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
    	InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingService racingService = new RacingService(randomNumberGenerator);
        CarRacingController carRacingController = new CarRacingController(inputView, resultView, racingService);

        carRacingController.run();
    	
    }
    
/*
 * Application 클래스
 * 
 * 1. 프로그램의 시작점 역할을 한다.
 * 2. 다양한 객체들을 초기화하고 연결하여 어플리케이션의 구조를 설정하는 역할을 한다.
 * 3. 어플리케이션의 전반적인 흐름을 제어한다.
 * 4. 타 클래스와 모듈을 연결하여 전체적인 구조를 형성한다. 
 *     
 */
}
