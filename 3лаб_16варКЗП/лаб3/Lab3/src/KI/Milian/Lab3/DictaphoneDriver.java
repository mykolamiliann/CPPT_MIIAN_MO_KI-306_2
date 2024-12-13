package KI.Milian.Lab3;

import java.io.IOException;

/**
 * Клас-драйвер для тестування класу Dictaphone.
 */
public class DictaphoneDriver {
    public static void main(String[] args) {
        try {
            // Створюємо диктофон
            Dictaphone dictaphone = new Dictaphone();

            // Використання функціональності диктофона
            dictaphone.deviceFunctionality();
            dictaphone.startRecording();
            dictaphone.stopRecording();
            dictaphone.playRecording();
            dictaphone.playTrack("Recorded Track");

            // Закриття ресурсів
            dictaphone.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
