package org.example.presenter;

import org.example.models.Toy;

import java.util.List;

public interface View {

    /**
     * Отображение списка игрушек в розыгрыше
     * @param toys
     */
    void showToys(List<Toy> toys);

    /**
     * Список выпавших призов
     * @param toyList
     */
    void showPrizeToysList(List<Toy> toyList);

    /**
     * Показать выпавшую игрушку
     * @param toy
     */
    void showPrizeToy(Toy toy);

    /**
     * Начало розыгрыша
     */
    void startDraw();

    /**
     * Окончание розыгрыша
     */
    void endDraw();

    /**
     * Запрос на продолжение розыгрыша
     */
    void isContinueDraw();

    /**
     * Вывод сообщения об удачном сохранении результатов
     */
    void saveResult();
}
