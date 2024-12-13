package KI.Milian.Lab3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас, що описує аудіоплеєр.
 */
public abstract class AudioPlayer {
    private Speaker speaker;
    private BluetoothModule bluetoothModule;
    private Battery battery;
    private FileWriter logWriter;

    public AudioPlayer(Speaker speaker, BluetoothModule bluetoothModule, Battery battery) throws IOException {
        this.speaker = speaker;
        this.bluetoothModule = bluetoothModule;
        this.battery = battery;
        this.logWriter = new FileWriter("audio_player_log.txt", true);
    }

    public AudioPlayer() throws IOException {
        this(new Speaker(50), new BluetoothModule(), new Battery(3000));
    }

    /**
     * Відтворює трек і зменшує заряд батареї.
     */
    public void playTrack(String track) throws IOException {
        if (battery.getCapacity() <= 0) {
            log("Battery is empty. Cannot play track.");
            System.out.println("Battery is empty. Please charge the device.");
            return;
        }

        if (bluetoothModule.isConnected()) {
            log("Playing track: " + track + " on device: " + bluetoothModule.getConnectedDevice());
            System.out.println("Playing track: " + track + " on Bluetooth device: " + bluetoothModule.getConnectedDevice());
        } else {
            log("Playing track: " + track + " on built-in speaker.");
            System.out.println("Playing track: " + track + " on built-in speaker.");
        }
        battery.drainBattery(50); // Витрачаємо 50 мАг на кожен трек
        log("Battery capacity after playing track: " + battery.getCapacity() + "mAh");
        System.out.println("Battery capacity after playing track: " + battery.getCapacity() + "mAh");
    }

    /**
     * Підключаємося до Bluetooth-пристрою і зменшуємо заряд батареї.
     */
    public void connectBluetooth(String device) throws IOException {
        if (battery.getCapacity() <= 0) {
            log("Battery is empty. Cannot connect to Bluetooth.");
            System.out.println("Battery is empty. Please charge the device.");
            return;
        }

        bluetoothModule.connectToDevice(device);
        log("Connected to Bluetooth device: " + device);
        System.out.println("Connected to Bluetooth device: " + device);
        battery.drainBattery(30); // Витрачаємо 30 мАг на підключення до Bluetooth
        log("Battery capacity after connecting to Bluetooth: " + battery.getCapacity() + "mAh");
        System.out.println("Battery capacity after connecting to Bluetooth: " + battery.getCapacity() + "mAh");
    }

    public void disconnectBluetooth() throws IOException {
        bluetoothModule.disconnect();
        log("Disconnected from Bluetooth device.");
        System.out.println("Disconnected from Bluetooth device.");
    }

    public void increaseVolume() throws IOException {
        speaker.setVolume(speaker.getVolume() + 10);
        log("Increased volume to: " + speaker.getVolume());
        System.out.println("Increased volume to: " + speaker.getVolume());
    }

    public void decreaseVolume() throws IOException {
        speaker.setVolume(speaker.getVolume() - 10);
        log("Decreased volume to: " + speaker.getVolume());
        System.out.println("Decreased volume to: " + speaker.getVolume());
    }

    public void chargeBattery(int amount) throws IOException {
        battery.setCapacity(battery.getCapacity() + amount);
        log("Charged battery by " + amount + "mAh. New capacity: " + battery.getCapacity() + "mAh");
        System.out.println("Charged battery by " + amount + "mAh. New capacity: " + battery.getCapacity() + "mAh");
    }

    protected void log(String message) throws IOException {
        logWriter.write(message + "\n");
    }

    public void close() throws IOException {
        if (logWriter != null) {
            logWriter.close();
        }
    }

    public int getCapacity() {
        return battery.getCapacity();
    }

    public void setCapacity(int capacity) {
        battery.setCapacity(capacity);
    }

    /**
     * Абстрактний метод для підкласів, що мають реалізовувати специфічні функції.
     */
    public abstract void deviceFunctionality() throws IOException;


    @Override
    public String toString() {
        return "AudioPlayer{speaker=" + speaker + ", bluetoothModule=" + bluetoothModule + ", battery=" + battery + "}";
    }
}