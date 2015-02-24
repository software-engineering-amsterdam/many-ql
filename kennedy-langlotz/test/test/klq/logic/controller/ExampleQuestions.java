package test.klq.logic.controller;

import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.operator.bool.GreaterEquals;
import com.klq.logic.expression.terminal.*;
import com.klq.logic.expression.terminal.Number;
import com.klq.logic.question.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class ExampleQuestions{

    public static List<Question> all(){
        List<Question> questions = new ArrayList<Question>();
        questions.add(q1());
        questions.add(q2());
        questions.add(q3());
        questions.add(q4());
        questions.add(q5());
        return questions;
    }

    public static Question q1(){
        Id id = new Id("question1");
        Text text = new Text("How old are you?");
        Question q = new Question(id, Type.NUMERAL, null, text, null);
        return q;
    }

    public static Question q2(){
        Id id = new Id("question2");
        List<AExpression> dependencies = new ArrayList<AExpression>();
        AExpression left = new Identifier("question1");
        AExpression right = new Number("18");
        GreaterEquals ge = new GreaterEquals(left, right);
        dependencies.add(ge);
        Text text = new Text("Do you have a driving license?");
        Question q = new Question(id, Type.DATE, null, text, dependencies);
        return q;
    }

    public static Question q3(){
        Id id = new Id("question3");
        OptionSet optionSet = new OptionSet();
        optionSet.add(new Answer("Yes"));
        optionSet.add(new Answer("Maybe"));
        optionSet.add(new Answer("No"));
        Text text = new Text("Do you like diz?");

        Question q = new Question(id, Type.SET, optionSet, text, null);
        return q;
    }

    public static Question q4(){
        Id id = new Id("question4");
        OptionSet optionSet = new OptionSet();
        optionSet.add(new Answer("Example Answer"));
        Text text = new Text("This is a question, that is even more long!?");

        Question q = new Question(id, Type.STRING, optionSet, text, null);
        return q;
    }

    public static Question q5(){
        Id id = new Id("question5");
        OptionSet optionSet = new OptionSet();
        optionSet.add(new Answer("So n grote Feuerball!"));
        optionSet.add(new Answer("BAM"));
        Text text = new Text("New Kids?");

        Question q = new Question(id, Type.SET, optionSet, text, null);
        return q;
    }
}
