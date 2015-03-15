package ql.tests;

import ql.semantics.errors.*;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by bore on 21/02/15.
 */
public class TypeChecker
{
    @Test
    public void duplicateLabelsWarning() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("duplicateLabels");
        assertEquals(1, ms.size());
        Warning w = TestHelper.as(ms.get(0), Warning.class);
        assertNotNull(w);
    }

    @Test
    public void ifCondBoolError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("ifCondIllegal");
        assertEquals(1, ms.size());
        TestHelper.assertErrorMessage(ms.get(0), "Error (Line 2): if statements should have conditions of type boolean");
    }

    @Test
    public void typeMismatchError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("typeMismatch");
        assertEquals(1, ms.size());
        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line 2): expression of type Add cannot have children of different type: integer and string");
    }

    @Test
    public void incorrectTypesError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("incorrectTypes");
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),"Error (Line 2): expression of type Or cannot children of type string");
    }

    @Test
    public void undeclaredIdError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("undeclaredIdentifier");
        assertEquals(1, ms.size());
        TestHelper.assertErrorMessage(ms.get(0),"Error (Line 2): identifier \"undeclId\" is not declared");
    }

    @Test
    public void defEvalMismatchError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("defEvalMismatch");
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line 2): Question \"quest\" is defined as type string, but is assigned expression of type boolean");
    }

    @Test
    public void duplicateIdentifiersError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("duplicateIdentifiers");
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line 2): identifier \"hasSoldHouse\" is already declared twice on lines 2 and 3");
    }

    @Test
    public void identifierDeclaredOfDiffTypeError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("identDeclaredOfDiffType");
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line: 2): Question \"hasSoldHouse\" is declared twice with a different type on line 2 and 3");
    }

    @Test
    public void cyclicQuestionsError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("cyclicQuestions");
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0), "Error: the following questions form a cyclic dependency: a, b, c");
    }

    @Test
    public void directCyclicQuestionsError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("directCyclicQuestions");
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0), "Error: the following questions form a cyclic dependency: income");
    }

    @Test
    public void manyCyclicQuestionsError() throws FileNotFoundException
    {
        Messages ms =  TestHelper.analyse("manyCyclicQuestions");
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),
                "Error: the following questions form a cyclic dependency: tas, has, mas");
    }

    @Test
    public void autoTypePromError() throws FileNotFoundException
    {
        Messages ms =  TestHelper.analyse("autoTypeProm");
        assertEquals(1, ms.size());

        TestHelper.assertErrorMessage(ms.get(0),
                "Error (Line 3): Question \"tax\" is defined as type integer, but is assigned expression of type decimal");
    }
}
