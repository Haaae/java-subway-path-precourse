package subway.controller;

import java.util.Scanner;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Distance;
import subway.domain.Time;
import subway.exceptionHandler.ExceptionHandler;
import subway.view.Enum.CriterionOfRoute;
import subway.view.Enum.Menu;
import subway.view.InputView;

public class Controller {

    private final WeightedMultigraph<String, Time> timeBasedSubwayMap;
    private final WeightedMultigraph<String, Distance> distanceBasedSubwayMap;

    public Controller(Scanner scanner) {
    }

    public void run() {
        Menu menu;
        do {
            menu = ExceptionHandler.input(InputView::readMenu);
            menu.process(this);
        } while (!menu.isQuit());
    }

    public void lookUpRoute() {
        // TODO: 기능 구현. 해당 함수는 Menu 열거형의 Consumer로 전달된다.
        CriterionOfRoute criterionOfRoute;
        do {
            criterionOfRoute = ExceptionHandler.input(InputView::readCriterionOfRoute);
            criterionOfRoute.process(this);
        } while (!criterionOfRoute.isBack());
    }

    public void lookUpShortestDistance() {
        // TODO: 기능 구현. 해당 함수는 Menu 열거형이 아닌 다른 열거형의 Consumer로 전달된다.
    }

    public void lookUpMinimunTime() {
        // TODO: 기능 구현
    }

    private void 기능_1을_위한_private함수() {
        // TODO: 기능 구현
    }
}

}
