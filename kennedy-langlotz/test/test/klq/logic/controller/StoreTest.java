package test.klq.logic.controller;

import com.klq.logic.controller.Store;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Boolean;
import com.klq.logic.expression.terminal.Number;
import com.klq.logic.question.Question;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Timon on 24.02.2015.
 */
public class StoreTest {

    @Test
    public void testStore(){
        Store store = new Store();
        Question q1 = ExampleQuestions.q1();
        Question q2 = ExampleQuestions.q2();
        Question q3 = ExampleQuestions.q3();
        store.add(q1);
        store.add(q2);
        store.add(q3);

        assertTrue(q2.getDependencyList().get(0) != Boolean.getTrue());
        q1.setResult(new Number("18"), true);
        assertTrue(q2.getDependencyList().get(0) == Boolean.getTrue());

        AExpression var = q3.getDependencyList().get(0);
        assertTrue(var != Boolean.getTrue());
        q2.setResult(Boolean.getTrue(), true);
        assertTrue(q3.getDependencyList().get(0) == Boolean.getTrue());
    }
}
