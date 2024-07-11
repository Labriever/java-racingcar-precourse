package racingcar.view;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Race;

public class ResultView {
    public void printRaceStatus(Race race) {
        for (Car car : race.getCars()) {
            System.out.println(car.getName() + ": " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }
}
