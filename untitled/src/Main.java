import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Тебе нужно отгадать число");
        int count = 0;
        int range = 100;
        int number = (int) (Math.random() * range);
        while (true) {
            count++;
            System.out.println("Угадайте число от 0 до " + range);
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println("Ты угадал!");
                {
                    break;
                }
            } else if (input_number > number) {
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
            } else {
                System.out.println("Я сам в шоке, но, загаданное число больше, брат");
            }
        }
        File file = new File ("myfile.txt");
        Scanner scanner2 = new Scanner(file);
        int bestScore = scanner2.nextInt();
        scanner.close();
        Integer intCount = count;
        if (bestScore > count) {
            try (FileWriter writer = new FileWriter("myfile.txt")) {
                String text = intCount.toString();
                writer.write(text);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        int result = bestScore>count?count:bestScore;
        System.out.println("Количество попыток: " + count);
        System.out.println("Лучшая попытка: " + result);
    }
}