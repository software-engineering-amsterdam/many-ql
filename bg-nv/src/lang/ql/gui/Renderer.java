package lang.ql.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nik on 17-02-2015
 */
public class Renderer extends Application
{

    private static Form unicornForm;

    public static void main(String[] args)
    {
        unicornForm = createUnicornForm();
        launch(args);
    }


    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 700, 500);
        primaryStage.setScene(scene);

        primaryStage.setTitle(unicornForm.getId());
        primaryStage.show();

        int i = 0;
        for (Statement s : unicornForm.getStatements())
        {
            Question q = (Question) s;
            HBox qBox = new HBox(10);

            Text statement = new Text(q.getText());
            qBox.getChildren().add(statement);

//            switch (q.getType())
//            {
//                case BOOLEAN:
//                    qBox.getChildren().add(new CheckBox());
//                    break;
//                case DATE:
//                case DECIMAL:
//                case INTEGER:
//                case STRING:
//                    qBox.getChildren().add(new TextField());
//                    break;
//            }

            grid.add(qBox, 0, i++);
        }

        Button btn = new Button("Make magic happen");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Unicorns!");
            }
        });

        primaryStage.show();
    }

    public static Form createUnicornForm()
    {
        List<Statement> statements = new ArrayList<Statement>();
//        statements.add(new Question("likeUnicorns", BOOLEAN, "Do you like unicorns?"));
//        statements.add(new Question("wantUnicorn", BOOLEAN, "Would you like to have a unicorn?"));
//        statements.add(new Question("howManyUnicorns", INTEGER, "How many unicorns can you accommodate?"));
        return new Form("Unicorn Form", statements, 1);
    }

}
