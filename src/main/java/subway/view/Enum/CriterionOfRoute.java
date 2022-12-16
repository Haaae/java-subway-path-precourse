package subway.view.Enum;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.controller.Controller;
import subway.exceptionHandler.ExceptionHandler;

public enum CriterionOfRoute {
    SHORTEST_DISTANCE("1", "최단 거리", Controller::lookUpShortestDistance),
    MINIMUM_TIME("2", "최소 시간", Controller::lookUpMinimunTime),
    BACK("B", "돌아가기", Controller -> {});

    private final String symbol;
    private final String name;
    private final Consumer<Controller> consumer;

    CriterionOfRoute(String symbol, String name, Consumer<Controller> consumer) {
        this.symbol = symbol;
        this.name = name;
        this.consumer = consumer;
    }

    public static CriterionOfRoute from(String symbol) {
        return Arrays.stream(CriterionOfRoute.values())
                .filter(CriterionOfRoute -> CriterionOfRoute.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        "[ERROR] 올바르지 않은 입력입니다."));
    }

    public void process(Controller controller) {
        ExceptionHandler.process(consumer, controller);
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isBack() {
        return this == BACK;
    }
}
