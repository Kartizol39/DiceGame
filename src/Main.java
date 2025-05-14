public class Main {

    // Определяем минимальное и максимальное возможные числа для игры
    static int minNumber = 1;
    static int maxNumber = 100;

    public static void main(String[] args) throws java.io.IOException {
        // Инициализируем переменные для хранения загаданного числа и количества попыток
        int secretNumber = (int) (Math.random() * (maxNumber - minNumber + 1)) + minNumber;
        int attempts = 0;

        // Инициализируем переменные для хранения лучшего результата
        int bestResult = Integer.MAX_VALUE;

        // Создаем BufferedReader для считывания ввода
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        // Главный цикл игры
        System.out.println("\u001B[41m" + "Спасайся брат! Взломщик запустил на твоем ПК зловредный вирус! " +
                "Ты должен победить его первым, чтобы сохранить свой жесткий диск, как хранилище самых важных данных!");
        System.out.println("Попробуй отгадать число от 1 до 100!:" + "\u001B[0m");
        while (true) {
            attempts++;

            // Спрашиваем пользователя о его предположении
            System.out.print("Предполагаемое число (или 'RESULT' для результата): ");
            String input = reader.readLine();

            // Проверяем, ввел ли пользователь 'R' для получения результата
            if (input.equalsIgnoreCase("RESULT")) {
                System.out.println("\u001B[41m" + "Текущий результат: " + "\u001B[0m" + attempts);
                System.out.println("\u001B[41m" + "Лучший результат: " + "\u001B[0m" + bestResult);
                continue;
            }

            // Пробуем преобразовать ввод в число
            int userGuess;
            try {
                userGuess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите допустимое число или 'R'.");
                attempts--; // Не увеличиваем попытку за неверный ввод
                continue;
            }

            // Проверяем, угадал ли пользователь число
            if (userGuess == secretNumber) {
                // Если да, поздравляем его и завершаем игру
                System.out.println("Поздравляю! Вы угадали число " + secretNumber + " за " + attempts + " попыток.");
                break;
            }
            // Если пользователь ввел число меньше загаданного
            else if (userGuess < secretNumber) {
                System.out.println("\u001B[41m" + "Я в шоке! Загаданное число больше, брат." + "\u001B[0m");
            }
            // Если пользователь ввел число больше загаданного
            else {
                System.out.println("\u001B[41m" + "Не ожидал от тебя такого! Загаданное число меньше, брат." + "\u001B[0m");
            }

            // Если количество попыток превысило лучший результат, обновляем лучший результат
            if (attempts < bestResult) {
                bestResult = attempts;
            }
        }

        System.out.println("\u001B[41m" + "Благодарим за игру! Надеемся, что в следующий раз вы быстрее справитесь с этим вирусом!" + "\u001B[0m");
        System.out.println("\u001B[41m" + "Текущий результат: " + "\u001B[0m" + attempts);
        System.out.println("\u001B[41m" + "Лучший результат: " + "\u001B[0m" + bestResult);
    }
}
