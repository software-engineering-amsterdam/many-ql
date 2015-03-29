import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ql.ast.form.Form;
import ql.gen.QLLexer;
import ql.gen.QLParser;
import ql.ast.AstBuilder;
import ql.gui.Modeler;
import ql.gui.Renderer;
import ql.gui.SimpleModeler;
import ql.gui.canvas.Canvas;
import ql.semantics.*;
import qls.semantics.TypeChecker;
import ql.semantics.errors.Messages;
import qls.ast.Stylesheet;
import qls.gen.QLSLexer;
import qls.gen.QLSParser;
import qls.gui.StyledModeler;
import qls.semantics.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        if (!(this.isQlFileSpecified()))
        {
            this.showErrorAlert("No ql file specified");
            System.exit(1);
        }

        String qlFile = getParameter(0);
        CharStream qlStream = getStream(qlFile);
        QLLexer qlLexer = new QLLexer(qlStream);
        QLParser qlParser = new QLParser(new CommonTokenStream(qlLexer));
        ParserRuleContext qlContext = qlParser.form();
        AstBuilder qlBuilder = new AstBuilder();
        Form form = (Form)qlBuilder.visit(qlContext);

        Messages ms = ql.semantics.TypeChecker.check(form);
        if (ms.containsError())
        {
            this.showErrorAlert(ms.toString());
            System.exit(1);
        }

        CondQuestionTable condQuestionTable = CondQuestionTableBuilder.flatten(form);
        Modeler modeler = new SimpleModeler(condQuestionTable);

        if (this.isQlsFileSpecified())
        {
            String qlsFile = getParameter(1);
            CharStream qlsStream = getStream(qlsFile);
            QLSLexer qlsLexer = new QLSLexer(qlsStream);
            QLSParser qlsParser = new QLSParser(new CommonTokenStream(qlsLexer));
            ParserRuleContext qlsContext = qlsParser.stylesheet();
            qls.ast.AstBuilder qlsBuilder = new qls.ast.AstBuilder();
            Stylesheet stylesheet = (Stylesheet)qlsBuilder.visit(qlsContext);

            Messages qlsMs =  TypeChecker.check(stylesheet, form);
// TODO: fix the ql and qls files and enable type checking
//            if (qlsMs.containsError())
//            {
//                this.showErrorAlert(qlsMs.toString());
//                System.exit(1);
//            }

            QuestionStyles questionStyles = StyleMerger.getStyles(stylesheet, form);
            modeler = new StyledModeler(condQuestionTable, stylesheet, questionStyles);
        }

        //TODO: move this part below + maybe pull out the attaching of listeners etc. from Renderer as well ?
        ValueTable valueTable = ValueTableBuilder.build(form);
        Canvas canvas = modeler.buildCanvas();

        canvas.setSubmitAction(e -> this.saveAction(primaryStage, condQuestionTable, valueTable));

        Renderer.display(valueTable, canvas, primaryStage);
    }

    private void saveAction(Stage primaryStage, CondQuestionTable condQuestionTable, ValueTable valueTable)
    {
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(filter);

        File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null)
        {
            DataStore dataStore = new FileStore(condQuestionTable, valueTable, file);
            try
            {
                dataStore.save();
            }
            catch (Exception ex)
            {
                this.showErrorAlert("Saving failed!");
            }
        }
    }


    private CharStream getStream(String file)
    {
        try
        {
            return new ANTLRFileStream(file);
        }
        catch (IOException ex)
        {
            System.err.print(ex.toString());
            System.exit(1);
        }

        return null;
    }

    private String getParameter(int n)
    {
        List<String> parameters = getParameters().getRaw();
        return parameters.get(n);
    }

    private boolean isQlFileSpecified()
    {
        return getParameters().getRaw().size() > 0;
    }

    private boolean isQlsFileSpecified()
    {
        return getParameters().getRaw().size() > 1;
    }

    private void showErrorAlert(String msg)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(msg);
        alert.showAndWait();
    }
}
