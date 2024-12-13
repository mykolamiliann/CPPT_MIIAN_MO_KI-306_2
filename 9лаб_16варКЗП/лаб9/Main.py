from Dictaphone import Dictaphone

# Основна точка входу програми.
if __name__ == "__main__":
    try:
        # Створюється екземпляр класу Dictaphone.
        dictaphone = Dictaphone()
        
        # Виклик методу для виведення інформації про готовність диктофона до роботи.
        dictaphone.device_functionality()
        
        # Початок запису аудіо. Якщо заряд батареї недостатній, запис не почнеться.
        print("Attempting to start recording...")
        dictaphone.start_recording()
        
        # Зупинка запису.
        print("Attempting to stop recording...")
        dictaphone.stop_recording()
        
        # Відтворення записаного аудіо. Якщо заряд батареї недостатній, відтворення не почнеться.
        print("Attempting to play recorded audio...")
        dictaphone.play_recording()
        
        # Відтворення треку "Recorded Track". Якщо підключено Bluetooth-пристрій, відтворення піде через нього,
        # інакше трек відтвориться через вбудований динамік.
        print('Attempting to play the track "Recorded Track"...')
        dictaphone.play_track("Recorded Track")
        
        # Виведення стану батареї після виконаних дій
        print(f"Current battery capacity: {dictaphone.get_capacity()}mAh")
        
    except Exception as e:
        # Обробка будь-яких винятків, що можуть виникнути під час виконання програми.
        print(f"Error: {e}")
