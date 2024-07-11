package racingcar.util;

public class InputValidator {
    public static void validateCarNames(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5 || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateMoveCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}

