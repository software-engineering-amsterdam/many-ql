package test.klq.logic.controller;

import com.klq.logic.controller.Store;
import com.klq.logic.expression.AExpression;
import com.klq.logic.question.Answer;
import com.klq.logic.question.Question;
import org.junit.Test;

/**
 * Created by Timon on 24.02.2015.
 */
public class StoreTest {

    @Test
    public void testStore(){
        Store store = new Store();
        Question q1 = ExampleQuestions.q1();
        Question q2 = ExampleQuestions.q2();
        store.add(q1);
        store.add(q2);

        for (AExpression dep : q2.getDependencies())
            System.out.println(dep);

        q1.setResult(new Answer("18"));

        for (AExpression dep : q2.getDependencies())
            System.out.println(dep);
    }
}
