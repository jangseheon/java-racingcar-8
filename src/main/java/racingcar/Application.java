package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            if(input == null) throw new IllegalArgumentException();
            String[] cars = input.split(",");
            validateInput(cars);
            System.out.println("시도할 횟수는 몇 회인가요?");
            int count = Integer.parseInt(Console.readLine());
            validateCount(count);
            int[] goCount = new int[cars.length];
            int i = 0;
            sequence(i, count, cars, goCount);
            int max = Arrays.stream(goCount).max().getAsInt();
            StringBuilder sb = new StringBuilder();
            winner(goCount, max, sb, cars);
            System.out.println("최종 우승자 : " + sb);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private static void validateCount(int count) {
        if(count <= 0) throw new IllegalArgumentException();
    }

    private static void validateInput(String[] cars) {
        if(cars == null) throw new IllegalArgumentException();
        for(int j = 0; j < cars.length; j++){
            if(cars[j].isBlank() || cars[j].length() > 5) throw new IllegalArgumentException();
        }
    }

    private static void winner(int[] goCount, int max, StringBuilder sb, String[] cars) {
        for(int i = 0; i < goCount.length; i++){
            if(goCount[i] == max) sb.append(cars[i]).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
    }

    private static void sequence(int i, long count, String[] cars, int[] goCount) {
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
