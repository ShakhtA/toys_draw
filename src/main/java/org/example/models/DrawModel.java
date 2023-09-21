package org.example.models;

import org.example.presenter.Model;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DrawModel implements Model {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);


    /**
     * список игрушек, участвующих в розыгрыше
     */
    private List<Toy> toyList;

    public List<Toy> getToyList() {
        return toyList;
    }


    /**
     * Список розыгрыша.
     * Все экземпляры игрушек
     */
    private List<Toy> drawList = new ArrayList<>();

    public List<Toy> getDrawList() {
        return drawList;
    }

    /**
     * Список выпавших игрушек
     */
    private List<Toy> prizeToysList;

    /**
     * Возвращает список выпавших игрушек.
     * @return
     */
    public List<Toy> getPrizeToysList() {
        return prizeToysList;
    }

    /**
     * Позволяет получить с консоли список игрушек, участвующих в розыгрыше.
     * Запрашивает у пользователя имя и частоту выпадения игрушки.
     *
     * @return список типов игршек в розыгрыше.
     */
    public List<Toy> loadToysList() {
        if (toyList == null) {
            toyList = new ArrayList<>();

            int totalProbability = 0;
            System.out.println("Внесите игрушки в список, указав имя и вероятность выпадения.\n" +
                    "Учтите, что сумма вероятностей должна быть равна 100\n");
            while (true) {
                System.out.print("Имя: ");
                String name = scanner.nextLine();
                //            int totalProbability = 0;
                do {
                    System.out.print("Частота выпадения в процентах (число от 1 до 99): ");
                    try {
                        int weight = Integer.parseInt(scanner.nextLine());
                        if (weight < 1 || weight > 99)
                            System.out.println("Неправильно введено значение. Повторите ввод.");
                        else {
                            Toy newToy = new Toy(name, weight);
                            toyList.add(newToy);
                            totalProbability += weight;
                            break;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Неверный ввод числового значения. Повторите ввод.");
                    }
                } while (true);
                System.out.println("Нажмите \"Enter\", чтобы добавить еще игрушку или любую клавишу для выхода");
                if (scanner.nextLine().equals("")) {
                    continue;
                }
                if (totalProbability == 100) {
                    System.out.println("Игрушки успешно добавлены!");
                    break;
                } else {
                    System.out.println("Неверно введены вероятности выпадения игрушек. Сумма вероятностей должна равняться 100.\n" +
                            "Повторите ввод:\n");
                    totalProbability = 0;
                    toyList.clear();
                }
            }
        }
        return toyList;
    }

    /**
     * Тур розыгрыша
     * @return призовой лист
     */
    public Toy draw() {
        drawList.clear();
        for (Toy toy : toyList) {
            for (int i = 0; i < toy.getWeight(); i++)
                drawList.add(toy);
        }
        if (prizeToysList == null) {
            prizeToysList = new ArrayList<>();
        }
        Toy prizeToy = drawList.get(random.nextInt(0, 100));
        prizeToysList.add(prizeToy);
        return prizeToy;
    }

    /**
     * Продолжение розыгрыша
     * @return
     */
    public boolean isContinueDraw() {
        return scanner.nextLine().equals("");
    }

    /**
     * Окончание розыгрыша
     * @return
     */
    public List<Toy> endDraw() {
        return getPrizeToysList();
    }

    /**
     * Сохранение результатов розыгрыша в файл
     */
    public void saveResult() throws IOException {
        FileWriter writer = new FileWriter("draw_result.txt");
        int cnt = 0;
        while (!getPrizeToysList().isEmpty()) {
            String tmp = String.format("Розыгрыш %2d: приз - %s\n",
                    ++cnt, getPrizeToysList().remove(0).getName());
            writer.write(tmp);
            }
            writer.close();
        }
}


