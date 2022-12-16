package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import subway.Application;
import subway.view.Enum.CriterionOfRoute;
import subway.view.Enum.Menu;

public class InputView {

    private static final String MENU_HEADLINE = "## 메인 화면";
    private static final String CRITERION_OF_ROUTE_HEADLINE = "## 경로 기준";
    private static final String DAT = ".";
    private static final String SPACE = " ";
    private static final String FUNCTION_SELECT_NOTICE = "## 원하는 기능을 선택하세요.";

    public static Menu readMenu() {
        printMenu();
        System.out.println();
        System.out.println(FUNCTION_SELECT_NOTICE);
        return Menu.from(Application.scanner.nextLine());
    }

    public static CriterionOfRoute readCriterionOfRoute() {
        printCriterionOfRoute();
        System.out.println();
        System.out.println(FUNCTION_SELECT_NOTICE);
        return CriterionOfRoute.from(Application.scanner.nextLine());
    }

    private static void printCriterionOfRoute() {
        System.out.println();
        System.out.println(CRITERION_OF_ROUTE_HEADLINE);

        for (Menu menu : Menu.values()) {
            System.out.println(menu.getSymbol()
                    + DAT
                    + SPACE
                    + menu.getName());
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println(MENU_HEADLINE);

        for (Menu menu : Menu.values()) {
            System.out.println(menu.getSymbol()
                    + DAT
                    + SPACE
                    + menu.getName());
        }
    }
}
