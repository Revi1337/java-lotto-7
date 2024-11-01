package lotto.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    public static final String SPLIT_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public int getPriceFromUser() {
//        String purchaseString = Console.readLine();
        String purchaseString = SCANNER.nextLine();
        return parseAsInteger(purchaseString);
    }

    public List<Integer> getWinningNumbersFromUser() {
//        String numberString = Console.readLine();
        String numberString = SCANNER.nextLine();
        return Arrays.stream(numberString.split(SPLIT_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public int getBonusNumberFromUser() {
//        String bonusNumberString = Console.readLine();
        String bonusNumberString = SCANNER.nextLine();
        return parseAsInteger(bonusNumberString);
    }

    private int parseAsInteger(String purchaseString) {
        try {
            return Integer.parseInt(purchaseString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 입력은 문자일 수 없습니다.");
        }
    }
}