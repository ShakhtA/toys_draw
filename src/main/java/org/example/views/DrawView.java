package org.example.views;

import org.example.models.*;
import org.example.presenter.View;
import java.util.List;

public class DrawView implements View {

    /**
     * Вывод на экран списка игрушек в розыгрыше
     * @param toys
     */
    public void showToys(List<Toy> toys) {
        System.out.println("\nСписок игрушек, участвующих в розыгрыше:\n");
        for (Toy toy : toys)
            System.out.println(String.format("id:%2d Имя: %-20s Вероятность выпадения: %d%%",
                    toy.getId(), toy.getName(), toy.getWeight()));
        System.out.println();
    }

    /**
     * Показать список выпавших призов
     * @param toyList
     */
    public void showPrizeToysList(List<Toy> toyList) {
        System.out.println("Список выпавших призов: \n");
        toyList.stream().map(e -> e.getName()).forEach(System.out::println);
    }

    /**
     * Показать выпавшую игрушку
     * @param toy
     */
    public void showPrizeToy(Toy toy) {
        System.out.printf("В текущем розыгрыше приз - %s\n", toy.getName());
    }

    /**
     * Объявление начала розыгрыша
     */
    public void startDraw() {
        System.out.println("Розыгрыш начался!\n");
    }

    /**
     * Запрос на продолжение розыгрыша
     */
    public void isContinueDraw() {
        System.out.println("Для продолжения розыгрыша нажмите \"Enter\", для выхода любую клавишу");
    }

    /**
     * Окончание розыгрыша
     */
    public void endDraw() {
        System.out.println("Розыгрыш окончен.\n");
    }

    /**
     * Вывод сообщения об удачном сохранении результатов
     */
    public void saveResult(){
        System.out.println("\nРезультаты розыгрыша успешно сохранены в файл");
    }
}




