package KI.Milian.Lab3;

/**
 * Клас, що описує акумулятор для аудіоплеєра.
 */
public class Battery {
    private int capacity;  // Ємність батареї в мАг (мілліампер-години)

    public Battery(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Зменшує заряд батареї на вказану кількість мАг.
     * Якщо заряд стає меншим за 0, встановлюється на 0.
     */
    public void drainBattery(int amount) {
        capacity -= amount;
        if (capacity < 0) {
            capacity = 0;
        }
    }

    @Override
    public String toString() {
        return "Battery{capacity=" + capacity + "mAh}";
    }
}