package ql.gui.canvas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import ql.gui.GuiElement;
import ql.gui.segment.Page;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nik on 22-02-2015
 */
public class Canvas extends GuiElement
{
    private final String name;
    private final List<Page> pages;
    private final Parent parent;
    private final Button submitButton;
    private final Node buttonBox;

    public Canvas(String name, List<Page> pages)
    {
        this(name, pages, true);
    }

    public Canvas(String name, List<Page> pages, Boolean visible)
    {
        super(visible);
        this.name = name;
        this.pages = pages;
        this.submitButton = new Button("Submit");
        this.buttonBox = this.createButtonBox();
        this.parent = this.createParent();
    }

    public Parent getGuiElement()
    {
        return this.parent;
    }

    private Parent createParent()
    {
        return this.displayPages() ? createTabsView() : createRegularView();
    }

    private Node createButtonBox()
    {
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.setPadding(new Insets(10, 50, 20, 50));
        buttonBox.getChildren().add(this.submitButton);
        return buttonBox;
    }

    private Boolean displayPages()
    {
        return this.pages.size() > 1;
    }

    private Region createRegularView()
    {
        VBox content = new VBox();
        content.setStyle("-fx-background-color: white;");
        for (Page page : this.pages)
        {
            content.getChildren().add(page.getContainer());
        }

        content.setPadding(new Insets(25, 50, 25, 50));
        content.getChildren().add(this.buttonBox);

        return this.createScrollBox(content);
    }

    private Region createTabsView()
    {
        List<Tab> tabs = this.pages.stream().map(this::createTab).collect(Collectors.toList());

        TabPane pane = new TabPane();
        pane.getTabs().addAll(tabs);
        pane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        return pane;
    }

    private Tab createTab(Page page)
    {
        VBox content = new VBox();
        content.setPadding(new Insets(25, 50, 25, 50));
        content.getChildren().addAll(page.getContainer(), this.buttonBox);
        content.setStyle("-fx-background-color: white;");

        ScrollPane scrollBox = this.createScrollBox(content);

        Tab tab = new Tab(page.getName());
        tab.setContent(scrollBox);
        return tab;
    }

    private ScrollPane createScrollBox(Node content)
    {
        ScrollPane scrollBox = new ScrollPane();
        scrollBox.setFitToWidth(true);
        scrollBox.setFitToHeight(true);
        scrollBox.setContent(content);
        return scrollBox;
    }

    public void setSubmitAction(EventHandler<ActionEvent> action)
    {
        this.submitButton.setOnAction(action);
    }

    public <T> T accept(CanvasVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    public String getName()
    {
        return name;
    }

    public List<Page> getPages()
    {
        return pages;
    }
}