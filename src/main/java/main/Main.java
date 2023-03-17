package main;

import presentation.controller.Controller;
import presentation.view.ClientView;
import presentation.view.MenuView;
import presentation.view.OrderView;
import presentation.view.ProductView;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */

public class Main {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        ClientView clientView = new ClientView();
        ProductView productView = new ProductView();
        OrderView orderView = new OrderView();
        Controller controller = new Controller(menuView, clientView, productView, orderView);
        menuView.setVisible(true);
    }
}