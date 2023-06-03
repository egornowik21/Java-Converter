public class Converter {
    final double distance;
    final double calories;
    final int converterkl;

    Converter(double distant, double color, int convert) {
        distance = distant;
        calories = color;
        converterkl = convert;
    }

    void findDistance(int startStep) {
        System.out.println("Всего пройдено " + startStep * distance / converterkl + " км");
    }

    void findCalories(int startStep) {
        System.out.println("Количество сожжённых килокалорий: " + startStep * calories / converterkl);
    }
}