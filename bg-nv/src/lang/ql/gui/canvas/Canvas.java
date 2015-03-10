package lang.ql.gui.canvas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lang.ql.gui.GuiElement;
import lang.ql.gui.ModelVisitor;
import lang.ql.gui.segment.Page;

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
    }

    public Parent getParent()
    {
        return this.parent;
    }

    private Parent createParent()
    {
        VBox content = new VBox();
        for (Page segment : this.pages)
        {
            content.getChildren().add(segment.getContainer());
        }

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.getChildren().add(this.submitButton);

        VBox contentWrapper = new VBox();
        contentWrapper.getChildren().addAll(content, buttonBox, this.submitMessage);
        contentWrapper.setPadding(new Insets(50, 50, 25, 50));
        contentWrapper.setStyle("-fx-background-color: white;");

//        ProgressBar pb = new ProgressBar(0);
//        pb.setPrefWidth(500);
//        contentWrapper.getChildren().add(pb);

        ScrollPane parent = new ScrollPane();
        parent.setFitToWidth(true);
        parent.setFitToHeight(true);
        parent.setContent(contentWrapper);
        return parent;
    }

    public void setSubmitAction(EventHandler<ActionEvent> action)
    {
        this.submitButton.setOnAction(action);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
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