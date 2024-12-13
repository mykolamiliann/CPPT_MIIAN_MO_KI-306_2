package KI.Milian.Lab6;

/**
 * Представляє житлову земельну ділянку
 */
public class ResidentialPlot implements Comparable<ResidentialPlot>{
    private String address;
    private double area;
    private double price;

    /**
     * Конструктор для житлової ділянки
     *
     * @param address Адреса ділянки
     * @param area    Площа ділянки в квадратних метрах
     * @param price   Ціна ділянки
     */
    public ResidentialPlot(String address, double area, double price) {
        this.address = address;
        this.area = area;
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Житлова ділянка{адреса='" + address + "', площа=" + area + ", ціна=" + price + "}";
    }

    @Override
    public int compareTo(ResidentialPlot other) {
        // Порівнюємо за ціною
        return Double.compare(this.price, other.price);
    }
}