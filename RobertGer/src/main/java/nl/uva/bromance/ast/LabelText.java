package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.NodeVisitor;
import nl.uva.bromance.visualization.Visualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabelText extends QLNode {
    private String text;
    private List<String> variables;

    public LabelText(int lineNumber, String text) {
        super(lineNumber);
        if (text != null) {
            this.text = text.substring(1, text.length() - 1); // Remove double brackets around text;
            variables = extractVariablesFromText(text);
        } else {
            System.err.println("Form Error: No text specified");
        }
    }

    private List<String> extractVariablesFromText(String txt) {
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(txt);
        while (matcher.find()) {
            stringList.add(matcher.group(1));
        }
        return stringList;

    }

    @Override
    public void visualize(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {
        parent.getChildren().add(new javafx.scene.control.Label(this.text));
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}
