package HomeWork7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller = new Controller();

    public void runApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название города на английском языке: ");
            String city = scanner.nextLine();

            setGlobalCity(city);

            System.out.println("Введите ответ: 1 - Получить текущую погоду, " +
                    "2 - Получить погоду на следующие 5 дней, " +
                    "выход (exit) - завершить работу");
            String result = scanner.nextLine();

            checkIsExit(result);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void checkIsExit(String result) {
        if (result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().setSelectedCity(city);
    }


    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Некорректный ввод: ожидается одно чисоло в ответе, фактически введено:  " + userInput);
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Некорректный ввод: это не число!");
        }
    }

    private void notifyController(String input) throws IOException {
        controller.onUserInput(input);
    }

}
