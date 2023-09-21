package org.example;

import org.example.presenter.DrawPresenter;
import org.example.presenter.Model;
import org.example.presenter.View;
import org.example.views.*;
import org.example.models.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Model model = new DrawModel();
        View view = new DrawView();

        DrawPresenter drawPresenter = new DrawPresenter(model, view);

        drawPresenter.showToys();
        drawPresenter.startDraw();
        do {
            drawPresenter.draw();

        } while (drawPresenter.isContinueDraw());
        drawPresenter.endDraw();
        try {
            drawPresenter.saveResultToFile();
        } catch (IOException e) {
            System.out.println("Файл не найден или не существует");
        }


//        int toursQuantity = drawPresenter.getToursQuantity();
//        List<Toy> prizeList = drawPresenter.draw(toursQuantity);
//        drawPresenter.showPrizeToysList(prizeList);

    }
}