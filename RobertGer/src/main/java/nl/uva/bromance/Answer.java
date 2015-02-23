package nl.uva.bromance;

import java.util.Optional;

/**
 * Created by Gerrit Krijnen on 2/17/2015.
 */
public class Answer {
    private String type;
    private String stringAnswer = null;
    private int intAnswer = -1;
    private boolean boolAnswer = false;

    public Answer(String type) {
        if ("int".equals(type.toLowerCase())) {
            this.type = "int";
        } else if ("string".equals(type.toLowerCase())) {
            this.type = "string";
        } else if ("boolean".equals(type.toLowerCase())) {
            this.type = "boolean";
        }
    }

    public boolean typeIsEqual(String type) {
        if (type != null && this.type != null && this.type.equals(type))
            return true;
        return false;
    }

    public String getType() {
        return this.type;
    }

    public void insertAnswer(int answer) {
        if ("int".equals(this.type)) {
            intAnswer = answer;
        } else {
            System.err.println("Error: Attempting to enter int on answer field of type :" + this.type);
        }
    }

    public void insertAnswer(boolean answer) {
        if ("boolean".equals(this.type)) {
            boolAnswer = answer;
        } else {
            System.err.println("Error: Attempting to enter boolean on answer field of type :" + this.type);
        }
    }

    public void insertAnswer(String answer) {
        if ("string".equals(this.type)) {
            stringAnswer = answer;
        } else {
            System.err.println("Error: Attempting to enter String on answer field of type :" + this.type);
        }
    }

    public Optional<Integer> getIntAnswer() {
        return Optional.of(intAnswer);
    }

    public Optional<Boolean> getBoolAnswer() {
        return Optional.of(boolAnswer);
    }

    public Optional<String> getStringAnswer() {
        return Optional.of(stringAnswer);
    }


}
