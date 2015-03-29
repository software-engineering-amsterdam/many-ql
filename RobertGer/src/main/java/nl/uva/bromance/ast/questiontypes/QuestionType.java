package nl.uva.bromance.ast.questiontypes;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.QuestionTypeVisitor;
import nl.uva.bromance.visualization.Visualizer;

import java.util.Map;

public interface QuestionType {

    public String getTypeString();

    public void addQuestionToPane(Pane parent, Map<String, Result> answerMap, Visualizer visualizer);

    public void accept(QuestionTypeVisitor visitor);
}