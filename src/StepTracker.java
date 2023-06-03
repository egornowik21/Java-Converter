import java.util.Scanner;
public class StepTracker {
    Integer[][] content = new Integer[12][30];
    int stepsGoal;

    StepTracker(int stepsgoal) {
        stepsGoal = stepsgoal;
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                content[i][j] = 0;
            }
        }
    }


    void monthData(Scanner scanner) {
        int bestSeries = 0;
        int bestSeriesMax = 0;
        int maxStep = 0;
        int allstep = 0;
        System.out.println("За какой месяц вы хотите получить лучшую серию шагов (от 1 до 12)?");
        int monthhh = scanner.nextInt();
        if (monthhh <= 0) {
            System.out.println("Введите число в диапозоне от 1 до 12");
        } else if (monthhh > 12) {
            System.out.println("Введите число в диапозоне от 1 до 12");
        } else {
            System.out.println("Месяц " + (monthhh));
            for (int j = 0; j < content[monthhh - 1].length; j++) {
                System.out.println("День " + (j + 1) + ". Пройдено " + content[monthhh - 1][j] + " шагов");
            }
            for (int j = 0; j < content[monthhh - 1].length; j++) {
                if (content[monthhh - 1][j] >= stepsGoal) {
                    bestSeries = bestSeries + 1;
                    if (bestSeries > bestSeriesMax) {
                        bestSeriesMax = bestSeries;
                    }
                } else {
                    bestSeries = 0;
                }
            }
            System.out.println("Лучшая серия составила: " + bestSeriesMax);
            int sumAllSteps = 0;
            int kolDays = 0;
            for (int j = 0; j < content[monthhh - 1].length; j++) {
                sumAllSteps += content[monthhh - 1][j];
                kolDays+=1;
            }
            System.out.println("Среднее количество шагов " + sumAllSteps / kolDays);
            for (int j = 0; j < content[monthhh - 1].length; j++) {
                if (content[monthhh - 1][j] > maxStep) {
                    maxStep = content[monthhh - 1][j];
                }
            }
            System.out.println("Самое большое количество шагов за этот месяц составило: " + maxStep);
            for (int j = 0; j < content[monthhh - 1].length; j++) {
                allstep += content[monthhh - 1][j];
            }
            System.out.println("Общее количество шагов за данный месяц: " + allstep);
        }
    }

    void changeStepsGoal(Scanner scanner) {
        System.out.println("Текущее значение: " + stepsGoal);
        System.out.println("Введите новое значение");
        int newGoal = scanner.nextInt();
        if (newGoal < 0) {
            System.out.println("Значение должно быть не меньше 0");
        } else {
            stepsGoal = newGoal;
            System.out.println("Изменена цель по количеству шагов. Новая цель: " + stepsGoal);
        }
    }


    int saveSteps(Scanner scanner, int startStep) {
        System.out.println("За какой месяц вы хотите ввести количество шагов (от 1 до 12)?");
        int month = scanner.nextInt();
        if (month <= 0) {
            System.out.println("Введите число в диапозоне от 1 до 12");
        } else if (month > 12) {
            System.out.println("Введите число в диапозоне от 1 до 12");
        } else {
            System.out.println("За какой день вы хотите ввести количество шагов (от 1 до 30)?");
            int day = scanner.nextInt();
            if (day <= 0) {
                System.out.println("Введите число в диапозоне от 1 до 30");
            } else if (day > 30) {
                System.out.println("Введите число в диапозоне от 1 до 30");
            } else {
                System.out.println("Введите количество пройденных шагов:");
                int step = scanner.nextInt();
                if (step<0) {
                    System.out.println("Вы ввели отрицательное количество шагов. Попробуйте заново");
                }
                else {
                    startStep = startStep + step;
                    content[month - 1][day - 1] += step;
                }
            }
        }


        return startStep;
    }

}






