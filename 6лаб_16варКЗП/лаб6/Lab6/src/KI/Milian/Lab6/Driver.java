package KI.Milian.Lab6;

/**
 * Головний клас для демонстрації функціональності LandPlotContainer
 */
public class Driver {
    public static void main(String[] args) {
        // Створюємо контейнер для житлових ділянок
        LandPlotContainer<ResidentialPlot> residentialContainer = new LandPlotContainer<>();

        // Додаємо житлові ділянки
        residentialContainer.addPlot(new ResidentialPlot("вул. Шевченка 1", 500, 100000));
        residentialContainer.addPlot(new ResidentialPlot("вул. Франка 5", 700, 150000));
        residentialContainer.addPlot(new ResidentialPlot("вул. Лесі Українки 10", 400, 80000));

        // Знаходимо та виводимо ділянку з мінімальною ціною
        System.out.println("Земельна ділянка з мінімальною ціною:");
        System.out.println(residentialContainer.findMinimum());

        // Створюємо контейнер для сільськогосподарських ділянок
        LandPlotContainer<AgriculturalPlot> agriculturalContainer = new LandPlotContainer<>();

        // Додаємо сільськогосподарські ділянки
        agriculturalContainer.addPlot(new AgriculturalPlot("Київська область", 50.5, "Чорнозем"));
        agriculturalContainer.addPlot(new AgriculturalPlot("Полтавська область", 30.0, "Суглинок"));
        agriculturalContainer.addPlot(new AgriculturalPlot("Черкаська область", 45.5, "Чорнозем"));

        // Знаходимо та виводимо ділянку з мінімальною площею
        System.out.println("\nЗемельна ділянка з мінімальною площею:");
        System.out.println(agriculturalContainer.findMinimum());
    }
}