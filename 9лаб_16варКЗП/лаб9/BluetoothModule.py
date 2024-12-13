# Клас BluetoothModule представляє Bluetooth-модуль, який може підключатися та відключатися від пристроїв.
class BluetoothModule:
    def __init__(self):
        # Ініціалізує модуль зі станом "не підключено" та порожньою назвою підключеного пристрою.
        self.is_connected = False
        self.connected_device = "None"

    # Метод для підключення до вказаного Bluetooth-пристрою.
    def connect_to_device(self, device):
        self.is_connected = True  # Встановлює статус підключення як True.
        self.connected_device = device  # Зберігає назву підключеного пристрою.

    # Метод для відключення від Bluetooth-пристрою.
    def disconnect(self):
        self.is_connected = False  # Встановлює статус підключення як False.
        self.connected_device = "None"  # Очищує назву підключеного пристрою.

    # Метод для перевірки стану підключення.
    def is_connected(self):
        return self.is_connected

    # Метод для отримання назви підключеного пристрою.
    def get_connected_device(self):
        return self.connected_device

    # Метод для формування рядкового представлення об'єкта BluetoothModule.
    def __str__(self):
        # Повертає інформацію про стан підключення та назву підключеного пристрою.
        return f"BluetoothModule{{isConnected={self.is_connected}, connectedDevice='{self.connected_device}'}}"
