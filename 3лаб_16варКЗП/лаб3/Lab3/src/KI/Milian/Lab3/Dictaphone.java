package KI.Milian.Lab3;

import java.io.IOException;

/**
 * Інтерфейс для пристроїв, що можуть записувати звук.
 */
interface Recordable {
    /**
     * Метод для початку запису.
     */
    void startRecording();

    /**
     * Метод для зупинки запису.
     */
    void stopRecording();
}

/**
 * Клас, що описує диктофон. Розширює абстрактний клас AudioPlayer та реалізує інтерфейс Recordable.
 */
public class Dictaphone extends AudioPlayer implements Recordable {
    private boolean isRecording;

    public Dictaphone(Speaker speaker, BluetoothModule bluetoothModule, Battery battery) throws IOException {
        super(speaker, bluetoothModule, battery);
        this.isRecording = false;
    }

    public Dictaphone() throws IOException {
        super();
        this.isRecording = false;
    }

    @Override
    public void startRecording() {
        if (getCapacity() <= 0) {
            System.out.println("Battery is empty. Cannot start recording.");
            return;
        }
        if (!isRecording) {
            isRecording = true;
            System.out.println("Recording started...");
            setCapacity(getCapacity()- 20); // Витрачаємо 20 мАг на початок запису
        } else {
            System.out.println("Already recording.");
        }
    }

    @Override
    public void stopRecording() {
        if (isRecording) {
            isRecording = false;
            System.out.println("Recording stopped.");
        } else {
            System.out.println("Not recording.");
        }
    }

    @Override
    public void deviceFunctionality() throws IOException {
        System.out.println("Dictaphone is ready for recording and playback.");
        log("Dictaphone initialized.");
    }

    public void playRecording() throws IOException {
        if (getCapacity() <= 0) {
            System.out.println("Battery is empty. Cannot play recording.");
            return;
        }
        System.out.println("Playing recorded audio...");
        setCapacity(getCapacity()- 30); // Витрачаємо 30 мАг на відтворення запису
    }

    @Override
    public String toString() {
        return "Dictaphone{isRecording=" + isRecording + ", battery=" + getCapacity() + "mAh}";
    }
}
