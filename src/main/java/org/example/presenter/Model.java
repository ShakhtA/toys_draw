package org.example.presenter;

import org.example.models.Toy;

import java.io.IOException;
import java.util.List;

public interface Model {

    /**
     * Получение списка игрушек, участвующих в розыгрыше
     * @return
     */
    List<Toy> loadToysList();

    /**
     * Розыгрыш игрушек
     */
    Toy draw();

    /**
     * Продолджение розыгрыша
     */
    boolean isContinueDraw();

    /**
     * Окончание розыгрыша
     * @return
     */
    List<Toy> endDraw();

    /**
     * Сохранение результата
     * @throws IOException
     */
    void saveResult() throws IOException;

}
