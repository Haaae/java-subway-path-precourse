package subway.view.Enum;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.controller.Controller;
import subway.exceptionHandler.ExceptionHandler;

public enum Menu {
    ROUTE_LOOKUP("1", "경로 조회", Controller::lookUpRoute),
    QUIT("Q", "종료", Controller -> {});

    private final String symbol;
    private final String name;
    private final Consumer<Controller> consumer;

    Menu(String symbol, String name, Consumer<Controller> consumer) {
        this.symbol = symbol;
        this.name = name;
        this.consumer = consumer;
    }

    public static Menu from(String symbol) {
        return Arrays.stream(Menu.values())
                .filter(Menu -> Menu.getSymbol().equals(symbol))
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

    public boolean isQuit() {
        return this == QUIT;
    }
}
