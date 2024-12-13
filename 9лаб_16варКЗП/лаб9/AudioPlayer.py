from Speaker import Speaker
from BluetoothModule import BluetoothModule
from Battery import Battery

# Клас AudioPlayer представляє плеєр, що може відтворювати аудіо через динамік або Bluetooth-пристрій,
# підключатися до Bluetooth і управляти рівнем заряду батареї.
class AudioPlayer:
    def __init__(self, speaker=None, bluetooth_module=None, battery=None):
        # Ініціалізація плеєра. Якщо динамік, модуль Bluetooth або батарея не передані, використовуються значення за замовчуванням.
        self.speaker = speaker if speaker else Speaker(50)  # Динамік з початковою гучністю 50
        self.bluetooth_module = bluetooth_module if bluetooth_module else BluetoothModule()  # Bluetooth-модуль
        self.battery = battery if battery else Battery(3000)  # Батарея з ємністю 3000 мА·год

    # Метод для відтворення аудіо-треку.
    def play_track(self, track):
        # Перевірка, чи батарея не розряджена.
        if self.battery.get_capacity() <= 0:
            print("Battery is empty. Please charge the device.")
            return

        # Відтворення треку через підключений Bluetooth-пристрій або через вбудований динамік.
        if self.bluetooth_module.is_connected:
            print(f"Playing track: {track} on Bluetooth device: {self.bluetooth_module.get_connected_device()}")
        else:
            print(f"Playing track: {track} on built-in speaker.")

        # Зменшення рівня заряду батареї на 50 мА·год після відтворення треку.
        self.battery.drain_battery(50)
        print(f"Battery capacity after playing track: {self.battery.get_capacity()}mAh")

    # Метод для підключення до Bluetooth-пристрою.
    def connect_bluetooth(self, device):
        # Перевірка, чи достатньо заряду для підключення.
        if self.battery.get_capacity() <= 0:
            print("Battery is empty. Please charge the device.")
            return

        # Підключення до вказаного Bluetooth-пристрою.
        self.bluetooth_module.connect_to_device(device)
        print(f"Connected to Bluetooth device: {device}")

        # Зменшення рівня заряду батареї на 30 мА·год після підключення.
        self.battery.drain_battery(30)
        print(f"Battery capacity after connecting to Bluetooth: {self.battery.get_capacity()}mAh")

    # Метод для відключення Bluetooth-пристрою.
    def disconnect_bluetooth(self):
        self.bluetooth_module.disconnect()
        print("Disconnected from Bluetooth device.")

    # Метод для збільшення гучності.
    def increase_volume(self):
        # Збільшення гучності на 10 одиниць.
        self.speaker.set_volume(self.speaker.get_volume() + 10)
        print(f"Increased volume to: {self.speaker.get_volume()}")

    # Метод для зменшення гучності.
    def decrease_volume(self):
        # Зменшення гучності на 10 одиниць.
        self.speaker.set_volume(self.speaker.get_volume() - 10)
        print(f"Decreased volume to: {self.speaker.get_volume()}")

    # Метод для заряджання батареї на задану кількість мА·год.
    def charge_battery(self, amount):
        # Збільшення ємності батареї на вказане значення.
        self.battery.set_capacity(self.battery.get_capacity() + amount)
        print(f"Charged battery by {amount}mAh. New capacity: {self.battery.get_capacity()}mAh")

    # Метод для отримання поточного рівня заряду батареї.
    def get_capacity(self):
        return self.battery.get_capacity()

    # Метод для встановлення нового рівня заряду батареї.
    def set_capacity(self, capacity):
        self.battery.set_capacity(capacity)

    # Метод для виведення інформації про готовність плеєра до роботи.
    def device_functionality(self):
        print("AudioPlayer is ready for playback.")
