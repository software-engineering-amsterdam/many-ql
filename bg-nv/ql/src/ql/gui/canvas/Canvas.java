package ql.gui.canvas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ql.gui.GuiElement;
import ql.gui.segment.Page;
import ql.semantics.errors.Message;
import ql.semantics.errors.Messages;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nik on 22-02-2015
 */
public class Canvas extends GuiElement
{
    private final String name;
    private final List<Page> pages;
    private final Parent parent;
    private final Button submitButton;
    private final Text submitMessage;
    private final List<Message> messages;

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
        this.submitMessage = new Text();
        this.parent = this.createParent();
        this.messages = new ArrayList<>();
    }

    public Parent getGuiElement()
    {
        return this.parent;
    }

    private Parent createParent()
    {
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.getChildren().add(this.submitButton);

        Node content = this.displayPages() ? createTabsView() : createRegularView();

        VBox contentBox = new VBox();
        contentBox.getChildren().addAll(content, buttonBox, this.submitMessage);
        contentBox.setPadding(new Insets(this.displayPages() ? 0 : 50, 50, 25, 50));
        contentBox.setStyle("-fx-background-color: white;");

        ScrollPane parent = new ScrollPane();
        parent.setFitToWidth(true);
        parent.setFitToHeight(true);
        parent.setContent(contentBox);

        return parent;
    }

    private Boolean displayPages()
    {
        return this.pages.size() > 1;
    }

    private Node createRegularView()
    {
        VBox content = new VBox();
        for (Page segment : this.pages)
        {
            content.getChildren().add(segment.getContainer());
        }

        VBox contentWrapper = new VBox();
        contentWrapper.getChildren().addAll(content, this.submitMessage);

        return contentWrapper;
    }

    private Node createTabsView()
    {
        List<Tab> tabs = new ArrayList<>();
        for (Page page : this.pages)
        {
            tabs.add(this.createTab(page));
        }

        //TODO: fix the CSS for the tabs header
        TabPane pane = new TabPane();
        pane.getTabs().addAll(tabs);

        return pane;
    }

    private Tab createTab(Page page)
    {
        Tab tab = new Tab(page.getName());
        tab.setContent(page.getContainer());
        tab.setClosable(false);
        return tab;
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

    public void addMessage(Message message)
    {
        this.messages.add(message);
    }

    public void clearMessages()
    {
        this.messages.clear();
    }


}