package nl.uva.softwcons;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nl.uva.softwcons.ql.FormBuilder;
import nl.uva.softwcons.ql.ast.form.Form;
import nl.uva.softwcons.ql.ui.UiBuilder;
import nl.uva.softwcons.ql.ui.layout.Layout;
import nl.uva.softwcons.ql.validation.Error;
import nl.uva.softwcons.ql.validation.Validator;
import nl.uva.softwcons.qls.StylesheetBuilder;
import nl.uva.softwcons.qls.ast.stylesheet.Stylesheet;
import nl.uva.softwcons.qls.ui.renderer.QLSRenderer;
import nl.uva.softwcons.qls.ui.widget.StyledWidgetFactory;
import nl.uva.softwcons.qls.validation.QLSValidator;

public class Main extends Application {

    public static void main(final String... args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Form form = FormBuilder.build(UiBuilder.class.getResourceAsStream("/form.ql"));
        final List<Error> validationErrors = Validator.validate(form);
        for (Error error : validationErrors) {
            System.err.println(error.getMessage());
            if (error.isFatal()) {
                System.exit(1);
            }
        }

        final Stylesheet stylesheet = StylesheetBuilder.build(UiBuilder.class
                .getResourceAsStream("/form_stylesheet.qls"));
        final List<Error> qlsValidationErrors = QLSValidator.validate(form, stylesheet);
        for (Error error : qlsValidationErrors) {
            System.err.println(error.getMessage());
            if (error.isFatal()) {
                System.exit(1);
            }
        }
        final Layout formLayout = UiBuilder.buildFrom(form, new QLSRenderer(stylesheet), new StyledWidgetFactory(form,
                stylesheet));

        final StackPane root = new StackPane();
        root.getChildren().add(formLayout.getNode());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
