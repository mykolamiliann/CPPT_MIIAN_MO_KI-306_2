package KI.Milian.Lab6;

/**
 * Представляє сільськогосподарську земельну ділянку
 */
public class AgriculturalPlot implements Comparable<AgriculturalPlot>{
    private String location;
    private double area;
    private String soilType;

    /**
     * Конструктор для сільськогосподарської ділянки
     * @param location Розташування ділянки
     * @param area Площа ділянки в гектарах
     * @param soilType Тип ґрунту
     */
    public AgriculturalPlot(String location, double area, String soilType) {
        this.location = location;
        this.area = area;
        this.soilType = soilType;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Сільськогосподарська ділянка{розташування='" + location + "', площа=" + area + ", тип ґрунту='" + soilType + "'}";
    }

    @Override
    public int compareTo(AgriculturalPlot other) {
        // Порівнюємо за площею
        return Double.compare(this.area, other.area);
    }
}
