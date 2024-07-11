package racingcar.controller;

import java.util.List;

import racingcar.model.Race;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class CarRacingController {
    private final InputView inputView;
    private final ResultView resultView;
    private final RacingService racingService;

    public CarRacingController(InputView inputView, ResultView resultView, RacingService racingService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.racingService = racingService;
    }

    public void run() {
        try {
            List<String> carNames = inputView.getCarNames();
            int moveCount = inputView.getMoveCount();
            Race race = racingService.initializeRace(carNames);
            for (int i = 0; i < moveCount; i++) {
                racingService.moveCars(race);
                resultView.printRaceStatus(race);
            }
            resultView.printWinners(racingService.findWinners(race));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            run(); // 잘못된 입력이 발생하면 다시 실행
        }
    }
}
