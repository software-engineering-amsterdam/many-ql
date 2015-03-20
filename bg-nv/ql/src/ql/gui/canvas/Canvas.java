package ql.gui.canvas;

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
import ql.gui.GuiElement;
import ql.gui.segment.Segment;

import java.util.List;

/**
 * Created by Nik on 22-02-2015
 */
public class Canvas extends GuiElement
{
    private final String name;
    private final List<Segment> segments;
    private final Parent parent;
    private final Button submitButton;
    private final Text submitMessage;

    public Canvas(String name, List<Segment> segments)
    {
        this(name, segments, true);
    }

    public Canvas(String name, List<Segment> segments, Boolean visible)
    {
        super(visible);
        this.name = name;
        this.segments = segments;
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
        for (Segment segment : this.segments)
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

    public <T> T accept(CanvasVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    public String getName()
    {
        return name;
    }

    public List<Segment> getSegments()
    {
        return segments;
    }
}