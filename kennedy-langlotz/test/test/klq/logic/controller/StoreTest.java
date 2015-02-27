package test.klq.logic.controller;

import com.klq.logic.controller.NoSuchQuestionException;
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

        assertTrue(q2.getDependencies().get(0) != Boolean.getTrue());
        try {
            store.updateAnswer(q1.getId(), new Number("18"));
        } catch (NoSuchQuestionException nsq){
            assertTrue(nsq.getMessage(), false);
        }
        assertTrue(q2.getDependencies().get(0) == Boolean.getTrue());

        AExpression var = q3.getDependencies().get(0);

        assertTrue(var != Boolean.getTrue());
        try {
            store.updateAnswer(q1.getId(), Boolean.getTrue());
        } catch (NoSuchQuestionException nsq){
            assertTrue(nsq.getMessage(), false);
        }
        assertTrue(q3.getDependencies().get(0) == Boolean.getTrue());
    }
}
