package KI.Milian.Lab2;

/**
 * Клас-драйвер для тестування аудіоплеєра.
 */
public class AudioPlayerDriver {
    public static void main(String[] args) {
        try {
            // Створюємо об'єкти для плеєра
            Speaker speaker = new Speaker(70);
            BluetoothModule bluetoothModule = new BluetoothModule();
            Battery battery = new Battery(4000);

            // Створюємо аудіоплеєр
            AudioPlayer player = new AudioPlayer(speaker, bluetoothModule, battery);

            // Тестуємо функціонал з виведенням у консоль
            player.connectBluetooth("Bluetooth Speaker");
            player.playTrack("Song 1");
            player.increaseVolume();
            player.chargeBattery(500); // Заряджаємо батарею
            player.disconnectBluetooth();
            player.playTrack("Song 2");

            // Закриваємо ресурси
            player.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}