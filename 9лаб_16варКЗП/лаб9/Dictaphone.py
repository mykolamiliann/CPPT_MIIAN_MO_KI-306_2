from AudioPlayer import AudioPlayer

from Speaker import Speaker
from BluetoothModule import BluetoothModule
from Battery import Battery

# Клас Dictaphone розширює функціональність AudioPlayer, додаючи можливість запису аудіо.
class Dictaphone(AudioPlayer):
    def __init__(self, speaker=None, bluetooth_module=None, battery=None):
        # Викликає конструктор батьківського класу AudioPlayer для ініціалізації динаміка, Bluetooth-модуля та батареї.
        super().__init__(speaker, bluetooth_module, battery)
        self.is_recording = False  # Змінна для відстеження стану запису (пише або не пише).

    # Метод для початку запису.
    def start_recording(self):
        # Перевіряє рівень заряду батареї, якщо батарея розряджена, запис не починається.
        if self.get_capacity() <= 0:
            print("Battery is empty. Cannot start recording.")
            return
        # Якщо запис ще не розпочато, починає запис і зменшує заряд батареї на 20 мА·год.
        if not self.is_recording:
            self.is_recording = True
            print("Recording started...")
            self.set_capacity(self.get_capacity() - 20)
        else:
            # Якщо запис вже триває, виводить повідомлення.
            print("Already recording.")

    # Метод для зупинки запису.
    def stop_recording(self):
        # Якщо диктофон записує, зупиняє запис.
        if self.is_recording:
            self.is_recording = False
            print("Recording stopped.")
        else:
            # Якщо запис не відбувається, виводить повідомлення.
            print("Not recording.")

    # Метод для відтворення записаного аудіо.
    def play_recording(self):
        # Перевіряє рівень заряду батареї, якщо батарея розряджена, відтворення неможливе.
        if self.get_capacity() <= 0:
            print("Battery is empty. Cannot play recording.")
            return
        # Відтворює запис і зменшує заряд батареї на 30 мА·год.
        print("Playing recorded audio...")
        self.set_capacity(self.get_capacity() - 30)

    # Перевизначений метод для виведення інформації про готовність диктофона до роботи.
    def device_functionality(self):
        print("Dictaphone is ready for recording and playback.")

    # Метод для формування рядкового представлення об'єкта Dictaphone.
    def __str__(self):
        # Повертає інформацію про стан запису та рівень заряду батареї.
        return f"Dictaphone{{isRecording={self.is_recording}, battery={self.get_capacity()}mAh}}"
