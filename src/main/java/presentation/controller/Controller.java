package presentation.controller;

import businessLogic.ClientBLL;
import businessLogic.OrderBLL;
import businessLogic.ProductBLL;
import businessLogic.validators.ProductValidator;
import com.itextpdf.text.DocumentException;
import model.Client;
import model.Orders;
import model.Product;
import presentation.view.*;
import presentation.view.add_update.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import static businessLogic.validators.ClientValidator.idValidator;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class Controller {
    private static MenuView menuView;
    private static ClientView clientView;
    private static ProductView productView;
    private static OrderView orderView;

    public Controller(MenuView mv, ClientView cv, ProductView pv, OrderView ov) {
        menuView = mv;
        clientView = cv;
        productView = pv;
        orderView = ov;

        menuView.clientButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientView.setVisible(true);
                menuView.setVisible(false);
                ClientBLL clientBLL = new ClientBLL();
                clientView.addClientButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AddClientView addClientView = new AddClientView();
                        clientView.setVisible(false);
                        addClientView.setVisible(true);
                        addClientView.addClientBackButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                addClientView.setVisible(false);
                                clientView.setVisible(true);
                            }
                        });
                        addClientView.addClientButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String result = clientBLL.insert(addClientView.clientNameField(), addClientView.passwordField());
                                addClientView.showResult(result);
                            }
                        });
                    }
                });
                clientView.updateClientButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateClientView updateClientView = new UpdateClientView();
                        clientView.setVisible(false);
                        updateClientView.setVisible(true);
                        updateClientView.updateClientBackButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                updateClientView.setVisible(false);
                                clientView.setVisible(true);
                            }
                        });
                        updateClientView.updateClientButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String result = clientBLL.update(updateClientView.oldNameField(), updateClientView.newNameField(), updateClientView.oldPasswordField(), updateClientView.newPasswordField());
                                updateClientView.showResult(result);
                            }
                        });
                    }
                });
                clientView.showClientsButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DisplayView<Client> displayView = new DisplayView<>(clientBLL.display());
                        clientView.setVisible(false);
                        displayView.setVisible(true);
                        displayView.backDisplayButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientView.setVisible(true);
                                displayView.setVisible(false);
                            }
                        });
                    }
                });
                clientView.removeClientButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clientView.setVisible(false);
                        DeleteView deleteView = new DeleteView();
                        deleteView.setVisible(true);
                        deleteView.setVisibleDeleteNameField(true);
                        deleteView.setVisiblelblNewLabel_1(true);
                        deleteView.setDeleteLabel("Delete Clients");
                        deleteView.deleteBackButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientView.setVisible(true);
                                deleteView.setVisible(false);
                            }
                        });
                        deleteView.deleteButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String result = "";
                                if(deleteView.deleteIdField().isEmpty() == false && idValidator(deleteView.deleteIdField()) != null) {
                                    result = clientBLL.deleteById(deleteView.deleteIdField());
                                    deleteView.showResult(result);
                                }
                                else
                                    if(deleteView.deleteNameField().isEmpty() == false) {
                                        result = clientBLL.deleteByName(deleteView.deleteNameField());
                                        deleteView.showResult(result);
                                    }
                                    else
                                        deleteView.showResult("Enter ID or name (will prioritize ID).");
                            }
                        });
                    }
                });
            }
        });
        menuView.productButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productView.setVisible(true);
                menuView.setVisible(false);
                ProductBLL productBLL = new ProductBLL();
                productView.addProductButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AddProductView addProductView = new AddProductView();
                        addProductView.setVisible(true);
                        productView.setVisible(false);
                        addProductView.addProductBackButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                addProductView.setVisible(false);
                                productView.setVisible(true);
                            }
                        });
                        addProductView.addProductButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String result = productBLL.insert(addProductView.productNameField(), addProductView.quantityField(), addProductView.priceField());
                                addProductView.showResult(result);
                            }
                        });
                    }
                });
                productView.removeProductButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DeleteView deleteView = new DeleteView();
                        deleteView.setVisible(true);
                        productView.setVisible(false);
                        deleteView.setVisibleDeleteNameField(true);
                        deleteView.setVisiblelblNewLabel_1(true);
                        deleteView.setDeleteLabel("Delete Products");
                        deleteView.deleteBackButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                productView.setVisible(true);
                                deleteView.setVisible(false);
                            }
                        });
                        deleteView.deleteButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String result = "";
                                if(deleteView.deleteIdField().isEmpty() == false && idValidator(deleteView.deleteIdField()) != null) {
                                    result = productBLL.deleteById(deleteView.deleteIdField());
                                    deleteView.showResult(result);
                                }
                                else
                                if(deleteView.deleteNameField().isEmpty() == false) {
                                    result = productBLL.deleteByName(deleteView.deleteNameField());
                                    deleteView.showResult(result);
                                }
                                else
                                    deleteView.showResult("Enter ID or product name (will prioritize ID).");
                            }
                        });
                    }
                });
                productView.showProductButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DisplayView<Product> displayView = new DisplayView<>(productBLL.display());
                        productView.setVisible(false);
                        displayView.setVisible(true);
                        displayView.backDisplayButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                productView.setVisible(true);
                                displayView.setVisible(false);
                            }
                        });
                    }
                });
                productView.updateProductButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateProductView updateProductView = new UpdateProductView();
                        productView.setVisible(false);
                        updateProductView.setVisible(true);
                        updateProductView.updateProductBackButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                updateProductView.setVisible(false);
                                productView.setVisible(true);
                            }
                        });
                        updateProductView.updateProductButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String result = productBLL.update(updateProductView.productNameOldField(), updateProductView.productNameNewField(), updateProductView.quantityOldField(), updateProductView.quantityNewField(), updateProductView.priceOldField(), updateProductView.priceNewField());
                                updateProductView.showResult(result);
                            }
                        });
                    }
                });
            }
        });
        menuView.orderButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderView.setVisible(true);
                menuView.setVisible(false);
                OrderBLL orderBLL = new OrderBLL();
                orderView.addOrderButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductBLL productBLL = new ProductBLL();
                        AddOrderView addOrderView = new AddOrderView(productBLL.display());
                        orderView.setVisible(false);
                        addOrderView.setVisible(true);
                        addOrderView.addOrderBackButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                addOrderView.setVisible(false);
                                orderView.setVisible(true);
                            }
                        });
                        addOrderView.addOrderButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String result = orderBLL.insert(addOrderView.orderClientField(), addOrderView.getProductComboBox(), addOrderView.orderQuantityField());
                                addOrderView.showResult(result);
                                if(result.equals("Order inserted.")) {
                                    try {
                                        orderBLL.createBill(new Orders(addOrderView.orderClientField(), addOrderView.getProductComboBox(), ProductValidator.quantityValidator(addOrderView.orderQuantityField())));
                                    } catch (FileNotFoundException ex) {
                                        throw new RuntimeException(ex);
                                    } catch (DocumentException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                            }
                        });
                    }
                });
                orderView.removeOrderButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DeleteView deleteView = new DeleteView();
                        deleteView.setVisible(true);
                        orderView.setVisible(false);
                        deleteView.setVisibleDeleteNameField(false);
                        deleteView.setVisiblelblNewLabel_1(false);
                        deleteView.setDeleteLabel("Delete Orders");
                        deleteView.deleteBackButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                orderView.setVisible(true);
                                deleteView.setVisible(false);
                            }
                        });
                        deleteView.deleteButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String result = orderBLL.deleteById(deleteView.deleteIdField());
                                deleteView.showResult(result);
                            }
                        });
                    }
                });
                orderView.showOrderButtonActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DisplayView<Orders> displayView = new DisplayView<>(orderBLL.display());
                        orderView.setVisible(false);
                        displayView.setVisible(true);
                        displayView.backDisplayButtonActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                orderView.setVisible(true);
                                displayView.setVisible(false);
                            }
                        });
                    }
                });
            }
        });
        clientView.backClientsButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientView.setVisible(false);
                menuView.setVisible(true);
            }
        });
        productView.backProductButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productView.setVisible(false);
                menuView.setVisible(true);
            }
        });
        orderView.backOrderButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderView.setVisible(false);
                menuView.setVisible(true);
            }
        });
    }
}
