import java.io.*;
import java.util.*;

/**
 * Клас Lab1Milian306 містить метод main, який дозволяє користувачеві
 * ввести розмір квадрата та символ для його заповнення, після чого
 * квадрат буде виведений на екран та збережений у файл.
 */
public class Lab1Milian306
{
    /**
     * Запитує в користувача розмір квадрата та символ для його заповнення,
     * малює квадрат та записує його у файл.
     *
     * @param args Аргументи командного рядка (не використовується).
     * @throws FileNotFoundException якщо файл для запису не вдається створити.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        // Створюємо сканер для зчитування даних з консолі
        Scanner scanner = new Scanner(System.in);

        // Запитуємо у користувача розмір квадрата
        System.out.print("Введіть розмір квадрата: ");
        int nRows = scanner.nextInt();

        // Запитуємо у користувача символ для заповнення квадрата
        System.out.print("Введіть символ для заповнення: ");
        String input = scanner.next();

        if(input.length() == 0) {
            System.out.print("Некорректний символ. Відсутній символ.");
            return;
        }
        else if(input.length() > 1) {
            System.out.print("Некорректний ввід. Забагато символів.");
            return;
        }
        char symbol = input.charAt(0);

        // Визначаємо відступ для порожньої рамки
        int offset = nRows/5;

        // Створюємо зубчастий масив для зберігання символів квадрата
        char[][] arr = new char[nRows - 2 * offset][];
        for (int i = 0; i < nRows - 2 * offset; i++) {
            // Визначаємо ширину рядка для заповненої частини
            if (i < offset || i >= nRows - 3 * offset) {
                // Зовнішні частини матимуть максимальну ширину
                arr[i] = new char[nRows - 2 * offset];
            } else {
                // Внутрішні частини матимуть меншу ширину
                arr[i] = new char[2 * offset];
            }
        }

        // Створюємо об'єкт для запису даних у файл
        PrintWriter fout = new PrintWriter("C:\\Users\\Микола\\Desktop\\3 курс 1 семестр\\КЗП\\1лаб_16варКЗП\\лаб1\\Lab1\\MyFile.txt");

        // Проходимо по кожному рядку і стовпцю для малювання квадрата
        for (int i = 0; i < nRows; i++) {
            int ArrIndx = 0; // Індекс для внутрішньої частини заповненого масиву
            for (int j = 0; j < nRows; j++) {
                // Перевіряємо, чи знаходиться координата в межах заповненої частини
                if (i >= offset && i < nRows - offset && j >= offset && j < nRows - offset &&
                        (i < 2 * offset || i >= nRows - 2 * offset || j < 2 * offset || j >= nRows - 2 * offset)) {
                    // Якщо в межах заповненої частини, додаємо символ до масиву
                    arr[i - offset][ArrIndx] = symbol;
                    fout.print(arr[i - offset][ArrIndx]); // Записуємо у файл
                    System.out.print(arr[i - offset][ArrIndx]); // Виводимо на екран
                    ArrIndx++; // Переходимо до наступної комірки внутрішнього масиву
                }
                else {
                    // Якщо поза межами заповненої частини, додаємо пробіл
                    fout.print(" ");
                    System.out.print(" ");
                }
            }
            // Додаємо новий рядок у файл і на екран
            fout.print("\n");
            System.out.println();
        }

        // Закриваємо файл після запису
        fout.flush();
        fout.close();
    }
}