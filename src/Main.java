import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter(75, 50, 100000);
        StepTracker stepTracker = new StepTracker(10000);
        int startStep = 0;
        int allstep = 0;
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            switch (userInput) {

                case 1:
                    startStep = stepTracker.saveSteps(scanner, startStep);
                    break;
                case 2:
                    System.out.println("1 - Получить статистику по месяцу");
                    System.out.println("0 - вернуться в главное меню");
                    int command = scanner.nextInt();

                    if (command == 1) {
                        stepTracker.monthData(scanner);
                        converter.findDistance(startStep);
                        converter.findCalories(startStep);
                    } else if (command == 0) {
                        System.out.println(" ");
                    } else {
                        System.out.println("Такой команды нет");
                    }
                    break;
                case 3:
                    stepTracker.changeStepsGoal(scanner);
                    break;
                default:
                    System.out.println("Такой команды нет");
                    break;
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }


    public static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения.");
    }
}
