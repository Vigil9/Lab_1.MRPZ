import java.util.Scanner;
import java.util.Random;

public class Lab1 {

    public static void main(String[] args) {

        // 1. Вивід прізвища та ініціалів розробника
        System.out.println("Розробник: Halla D.");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 2. Введення розміру квадратної матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        // 3. Заповнення матриці випадковими числами (від 1 до 9)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(9) + 1;
            }
        }

        // 4. Вивід матриці
        System.out.println("\nМатриця:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // 5. Перевірка на магічний квадрат
        boolean isMagic = true;

        // Сума першого рядка
        int magicSum = 0;
        for (int j = 0; j < n; j++) {
            magicSum += matrix[0][j];
        }

        // Перевірка рядків
        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                isMagic = false;
                break;
            }
        }

        // Перевірка стовпців
        for (int j = 0; j < n && isMagic; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                isMagic = false;
                break;
            }
        }

        // Перевірка головної діагоналі
        int diag1 = 0;
        for (int i = 0; i < n; i++) {
            diag1 += matrix[i][i];
        }

        if (diag1 != magicSum) {
            isMagic = false;
        }

        // Перевірка побічної діагоналі
        int diag2 = 0;
        for (int i = 0; i < n; i++) {
            diag2 += matrix[i][n - 1 - i];
        }

        if (diag2 != magicSum) {
            isMagic = false;
        }

        // 6. Вивід результату
        System.out.println("\nМагічна сума: " + magicSum);

        if (isMagic) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця НЕ є магічним квадратом.");
        }

        scanner.close();
    }
}