package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.RandomNumberGenerator;

public class RacingService {
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Race initializeRace(List<String> carNames) {
        List<Car> cars = carNames.stream()
                                 .map(Car::new)
                                 .collect(Collectors.toList());
        return new Race(cars);
    }

    public void moveCars(Race race) {
        for (Car car : race.getCars()) {
            if (randomNumberGenerator.generate() >= 4) {
                car.move();
            }
        }
    }

    public List<String> findWinners(Race race) {
        int maxPosition = race.getCars().stream()
                               .mapToInt(Car::getPosition)
                               .max()
                               .orElse(0);

        return race.getCars().stream()
                   .filter(car -> car.getPosition() == maxPosition)
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }
}
