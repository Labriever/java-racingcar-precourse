package racingcar;

public class CheckError {
	// 추가 기능 구현
		public void isName(String names){
//	      자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
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
		
		public void isCount(int count) {
			if(count > 5 || count < 1) {
				throw new IllegalArgumentException(printError(3));
			}
		}
		
//      사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
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
