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
        TestHelper.assertMsContainError(ms,"The following questions have identical labels: hasSoldHouse, privateDebt");
    }

    @Test
    public void ifCondBoolError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("ifCondIllegal");
        TestHelper.assertMsContainError(ms, "Error (Line 2): if statements should have conditions of type boolean");
    }

    @Test
    public void typeMismatchError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("typeMismatch");
        TestHelper.assertMsContainError(ms,
                "Error (Line 2): expression of type Add cannot have children of different type: integer and string");
    }

    @Test
    public void incorrectTypesError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("incorrectTypes");
        TestHelper.assertMsContainError(ms, "Error (Line 2): expression of type Or cannot children of type string");
    }

    @Test
    public void undeclaredIdError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("undeclaredIdentifier");
        TestHelper.assertMsContainError(ms, "Error (Line 2): identifier \"undeclId\" is not declared");
    }

    @Test
    public void defEvalMismatchError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("defEvalMismatch");
        TestHelper.assertMsContainError(ms,
                 "Error (Line 2): Question \"quest\" is defined as type string, but is assigned expression of type boolean");
    }

//    @Test
//    public void duplicateIdentifiersError() throws FileNotFoundException
//    {
//        Messages ms = TestHelper.analyse("duplicateIdentifiers");
//        assertEquals(1, ms.size());
//
//        TestHelper.assertErrorMessage(ms.get(0),
//                "Error : multiple declarations of identifier \"hasSoldHouse\" on lines: 2, 3");
//    }

    @Test
    public void identifierDeclaredOfDiffTypeError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("identDeclaredOfDiffType");
        TestHelper.assertMsContainError(ms,
                "Error : multiple declarations of identifier \"hasSoldHouse\" on lines: 2, 3");
    }

    @Test
    public void cyclicQuestionsError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("cyclicQuestions");
        TestHelper.assertMsContainError(ms, "Error: the following questions form a cyclic dependency: a, b, c");
    }

    @Test
    public void directCyclicQuestionsError() throws FileNotFoundException
    {
        Messages ms = TestHelper.analyse("directCyclicQuestions");
        TestHelper.assertMsContainError(ms, "Error: the following questions form a cyclic dependency: income");
    }

    @Test
    public void manyCyclicQuestionsError() throws FileNotFoundException
    {
        Messages ms =  TestHelper.analyse("manyCyclicQuestions");
        TestHelper.assertMsContainError(ms, "Error: the following questions form a cyclic dependency: tas, has, mas");
    }

    @Test
    public void autoTypePromError() throws FileNotFoundException
    {
        Messages ms =  TestHelper.analyse("autoTypeProm");
        TestHelper.assertMsContainError(ms,
                "Error (Line 3): Question \"tax\" is defined as type integer, but is assigned expression of type decimal");
    }
}
