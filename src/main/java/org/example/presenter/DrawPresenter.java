package org.example.presenter;

import org.example.models.*;
import java.io.IOException;
import java.util.List;

public class DrawPresenter {

    private Model model;
    private View view;


    public DrawPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Получение с коносоли списка участвующих в розыгрыше игрушек
     * @return
     */
    public List<Toy> loadToysList() {
        return model.loadToysList();
    }

    /**
     * Вывод на экран игрушки
     */
    public void showToys() {
        view.showToys(loadToysList());
    }

    /**
     * Один тур розыгрыша
     */
    public void draw() {
        Toy prizeToy = model.draw();
        view.showPrizeToy(prizeToy);
    }

    /**
     * Начало розыгрыша
     */
    public void startDraw() {
        view.startDraw();
    }

    /**
     * Запрос на продолжение розыгрыша
     * @return
     */
    public boolean isContinueDraw() {
        view.isContinueDraw();
        return model.isContinueDraw();
    }

    /**
     * Окончание розыгрыша
     */
    public void endDraw() {
        view.endDraw();
        view.showPrizeToysList(model.endDraw());
    }

    /**
     * Сохранение результатов розыгрыша в файл
     * @throws IOException
     */
    public void saveResultToFile() throws IOException {
            model.saveResult();
            view.saveResult();
    }

    /**
     * Просмотр списка призовых игрушек
     * @param toyList
     */
    public void showPrizeToysList(List<Toy> toyList) {
        view.showPrizeToysList(toyList);
    }
}
