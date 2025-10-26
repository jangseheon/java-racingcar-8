package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        long count = Long.parseLong(Console.readLine());
        String[] cars = input.split(",");
        int[] goCount = new int[cars.length];
        int i = 0;
        while(i < count){
            for(int j = 0; j < cars.length; j++){
                int random = Randoms.pickNumberInRange(0,9);
                attemptToMove(goCount,j,random);
                System.out.println(cars[j] + " : " + "-".repeat(goCount[j]));
            }
            System.out.println();
            i++;
        }
    }

    static void attemptToMove(int[] goCount,int goCount_index, int random){
        if(random >= 4)
            goCount[goCount_index]++;
    }
}
