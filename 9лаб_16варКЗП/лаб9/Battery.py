# Клас Battery представляє батарею з певною ємністю, що дозволяє керувати її зарядом.
class Battery:
    def __init__(self, capacity):
        # Ініціалізує батарею з заданою ємністю.
        self.capacity = capacity

    # Метод для отримання поточної ємності батареї.
    def get_capacity(self):
        return self.capacity

    # Метод для встановлення нової ємності батареї.
    def set_capacity(self, capacity):
        self.capacity = capacity

    # Метод для розряду батареї на вказану величину.
    def drain_battery(self, amount):
        self.capacity -= amount  # Зменшує ємність батареї на вказану величину.
        if self.capacity < 0:
            self.capacity = 0  # Якщо ємність менша за 0, встановлює її в 0.

    # Метод для формування рядкового представлення об'єкта Battery.
    def __str__(self):
        # Повертає інформацію про поточну ємність батареї в мА·год.
        return f"Battery{{capacity={self.capacity}mAh}}"
