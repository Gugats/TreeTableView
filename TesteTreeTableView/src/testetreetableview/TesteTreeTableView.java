/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testetreetableview;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author gustavomaia
 */
public class TesteTreeTableView extends Application {

    List<Item> itens = Arrays.<Item>asList(new Item(1.1, "Locação", 55, 406.60),
            new Item(1.2, "Abertura de Brocas", 36, 648.00),
            new Item(1.3, "Escavação", 6, 251.13));

    final TreeItem<Item> root = new TreeItem<>(new Item(1.0, "FUNDAÇÃO", null, null));

    @Override
    public void start(Stage stage) {

        root.setExpanded(true);

        itens.stream().forEach((employee) -> {
            root.getChildren().add(new TreeItem<>(employee));
        });

        stage.setTitle("Tree Table View Orçamento");
        final Scene scene = new Scene(new Group(), 400, 400);
        Group sceneRoot = (Group) scene.getRoot();

        TreeTableColumn<Item, Number> itemCol = new TreeTableColumn<>("Item");
        itemCol.setPrefWidth(150);
        itemCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<Item, Number> param)
                -> new ReadOnlyDoubleWrapper(param.getValue().getValue().getNum())
        );

        TreeTableColumn<Item, String> descCol = new TreeTableColumn<>("Discriminação");
        descCol.setPrefWidth(150);
        descCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<Item, String> param)
                -> new ReadOnlyStringWrapper(param.getValue().getValue().getDesc())
        );

        TreeTableColumn<Item, Number> qtdCol = new TreeTableColumn<>("Quantidade");
        qtdCol.setPrefWidth(150);
        qtdCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<Item, Number> param)
                -> new ReadOnlyIntegerWrapper(param.getValue().getValue().getQtd())
        );

        TreeTableColumn<Item, Number> totalCol = new TreeTableColumn<>("Total");
        totalCol.setPrefWidth(150);
        totalCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<Item, Number> param)
                -> new ReadOnlyDoubleWrapper(param.getValue().getValue().getValor())
        );

        TreeTableView<Item> tabela = new TreeTableView<>(root);
        tabela.getColumns().setAll(itemCol, descCol, qtdCol, totalCol);
        tabela.setTableMenuButtonVisible(true);

        ContextMenu addMenu = new ContextMenu();
        tabela.setContextMenu(addMenu);
        
        MenuItem addMenuItem = new MenuItem("Add Employee");
        addMenu.getItems().add(addMenuItem);
        addMenuItem.setOnAction(new EventHandler() {
            public void handle(Event t) {
                TreeItem newEmployee
                        = new TreeItem<String>("New Employee");
                tabela.getTreeItem(1).getChildren().add(newEmployee);
            }
        });

        tabela.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tabela.getSelectionModel().setCellSelectionEnabled(true);

        sceneRoot.getChildren().add(tabela);

        scene.getStylesheets().add("/myStyle.css");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
