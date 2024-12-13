# Клас Speaker представляє динамік із можливістю керування гучністю.
class Speaker:
    def __init__(self, volume):
        # Ініціалізує динамік із початковою гучністю.
        self.volume = volume

    # Метод для отримання поточного рівня гучності.
    def get_volume(self):
        return self.volume

    # Метод для встановлення нового рівня гучності.
    def set_volume(self, volume):
        self.volume = volume

    # Метод для формування рядкового представлення об'єкта Speaker.
    def __str__(self):
        # Повертає інформацію про поточний рівень гучності динаміка.
        return f"Speaker{{volume={self.volume}}}"
