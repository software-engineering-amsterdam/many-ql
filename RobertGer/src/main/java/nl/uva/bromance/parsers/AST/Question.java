package nl.uva.bromance.parsers.AST;

import nl.uva.bromance.parsers.AST.Range.Range;

import java.util.Arrays;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Question extends Node {
    private static final String[] parentsAllowed = {"Form","Conditional"};
    // TODO: Implement custom question type and remove here
    private static final String[] questionTypes = {"integer","string","boolean","custom"};

    private String identifier;
    private String questionString;
    private String questionType;
    private Range questionRange;

    public Question(String id){
        super();
        this.setAcceptedParents(parentsAllowed);
        if (id != null) {
            this.identifier = id;
        } else {
            System.err.println("Question Error: No identifier specified");
        }
    }
    public void setQuestionString(String qs){
        if (qs != null) {
            this.questionString = qs;
        } else {
            System.err.println("Question Error: No question asked");
        }
    }
    public void setQuestionType(String qt){
        qt = qt.toLowerCase();
        boolean valid = false;
        for (String type: questionTypes){
            if (type.equals(qt)){
                valid = true;
                break;
            }
        }
        if (valid){
            this.questionType = qt;
        } else {
            System.err.println("Question Error: Invalid Question type "+qt+", valid types are :"+ Arrays.toString(questionTypes));
        }
    }
    public void setQuestionRange(Range r){
        this.questionRange = r;
    }

    public void printDebug(int i){
        for (int j=0; j < i; j++){
            System.out.print("\t");
        }
        System.out.print("[Question] { Name : "+this.identifier+" , QuestionString: "+this.questionString+" , Type: "+this.questionType+" , Range: "+this.questionRange+" }\n");
        for (Node n :children){
            n.printDebug(i+1);
        }

    }

}
