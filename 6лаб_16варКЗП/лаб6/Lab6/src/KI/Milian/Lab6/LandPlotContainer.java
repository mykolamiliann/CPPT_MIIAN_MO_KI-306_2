package KI.Milian.Lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Узагальнений клас-контейнер для управління земельними ділянками
 * @param <T> Тип елементів для зберігання, що реалізує інтерфейс Comparable
 */
public class LandPlotContainer<T extends Comparable<T>> {
    private List<T> plots;

    /**
     * Конструктор ініціалізує порожній контейнер
     */
    public LandPlotContainer() {
        this.plots = new ArrayList<>();
    }

    /**
     * Додає новий елемент до контейнера
     * @param plot Елемент для додавання
     */
    public void addPlot(T plot) {
        plots.add(plot);
    }

    /**
     * Видаляє елемент з контейнера
     * @param plot Елемент для видалення
     * @return true якщо елемент був видалений, false в іншому випадку
     */
    public boolean removePlot(T plot) {
        return plots.remove(plot);
    }

    /**
     * Знаходить мінімальний елемент у контейнері
     * @return Мінімальний елемент або null якщо контейнер порожній
     */
    public T findMinimum() {
        if (plots.isEmpty()) {
            return null;
        }
        T min = plots.get(0);
        for (T plot : plots) {
            if (plot.compareTo(min) < 0) {
                min = plot;
            }
        }
        return min;
    }

    /**
     * Отримує всі елементи в контейнері
     * @return Список всіх елементів
     */
    public List<T> getAllPlots() {
        return new ArrayList<>(plots);
    }
}
