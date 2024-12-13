package KI.Milian.Lab2;

/**
 * Клас, що описує динамік аудіоплеєра.
 */
public class Speaker {
    private int volume; // Гучність динаміка

    public Speaker(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Speaker{volume=" + volume + "}";
    }
}