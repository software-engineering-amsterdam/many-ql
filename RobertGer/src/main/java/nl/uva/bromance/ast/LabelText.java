package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.visitors.NodeVisitor;
import nl.uva.bromance.visualization.Visualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabelText extends QLNode {
    private String text;
    private List<String> variables;

    public LabelText(int lineNumber, String text) {
        super(lineNumber, LabelText.class);
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
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[LabelText] { Text : " + this.text + ", Variables : [");
        boolean first = true;
        for (String var : variables) {
            if (first) {
                first = false;
                System.out.print(var);
            } else {
                System.out.print("," + var);
            }
        }
        System.out.print("]} \n");
        for (QLNode n : getChildren()) {
            n.printDebug(i + 1);
        }

    }

    @Override
    public Optional<? extends Pane> visualize(Pane parent, Map<String, String> answerMap, Visualizer visualizer) {

        parent.getChildren().add(new javafx.scene.control.Label(this.text));

        return null;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
        for(QLNode child: this.getChildren()) {
            child.accept(visitor);
        }
    }
}
