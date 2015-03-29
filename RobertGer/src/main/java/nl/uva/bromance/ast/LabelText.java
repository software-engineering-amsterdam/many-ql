package nl.uva.bromance.ast;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;
import nl.uva.bromance.visualization.Visualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabelText extends QLNode {
    private String baseText;
    private String insertedText;
    private Map<String, Result> answerMap;
    private List<String> variables;
    private javafx.scene.control.Label uiLabel;
    private boolean isVisible = true;

    public LabelText(int lineNumber, String text) {
        super(lineNumber);
        if (text != null) {
            this.baseText = text.substring(1, text.length() - 1); // Remove double brackets around text;
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

    public void addToPane(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {
        this.answerMap = answerMap;
        insertVariablesInText();
        // Explicit package because of parent class named Label ;)
        uiLabel = new javafx.scene.control.Label(this.insertedText);
        uiLabel.setVisible(isVisible);
        parent.getChildren().add(uiLabel);
    }

    public void insertVariablesInText() {
        String txt = this.baseText;
        for (String var : variables) {
            String replaceString = "[" + var + "]";
            Result result = answerMap.get(var);
            if (result != null) {
                txt = txt.replace(replaceString, result.toString());
            } else {
                txt = txt.replace(replaceString, "");
            }
        }
        this.insertedText = txt;
    }

    @Override
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void refresh() {
        insertVariablesInText();
        uiLabel.setText(insertedText);
        uiLabel.setVisible(isVisible);
    }

    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}
