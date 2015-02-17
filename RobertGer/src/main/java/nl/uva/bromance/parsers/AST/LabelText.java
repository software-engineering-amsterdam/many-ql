package nl.uva.bromance.parsers.AST;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class LabelText extends Node {
    private static final String[] parentsAllowed = {"Label","IfStatement","ElseIfStatement","ElseStatement"};
    private String text;
    private List<String> variables;

    public LabelText(int lineNumber, String text){
        super(lineNumber,"LabelText");
        this.setAcceptedParents(parentsAllowed);
        if (text != null) {
            this.text = text;
            variables = extractVariablesFromText(text);
        } else {
            System.err.println("Form Error: No text specified");
        }
    }

    private List<String> extractVariablesFromText(String txt){
        List<String> stringList = new ArrayList();
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(txt);
        while (matcher.find()){
            stringList.add(matcher.group(1));
        }
        return stringList;

    };
    @Override
    public void printDebug(int i){
        for (int j=0; j < i; j++){
            System.out.print("\t");
        }
        System.out.print("[LabelText] { Text : "+this.text+", Variables : [");
        boolean first = true;
        for (String var : variables){
            if (first){
                first = false;
                System.out.print(var);
            }
            else {
                System.out.print("," + var);
            }
        }
        System.out.print("]} \n");
        for (Node n :children){
            n.printDebug(i+1);
        }

    }

}
