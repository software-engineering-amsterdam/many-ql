package org.uva.ql.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.uva.ql.test.evaluator.EvaluatorTest;
import org.uva.ql.test.typechecker.TypeCheckerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TypeCheckerTest.class, EvaluatorTest.class

})
public class QLChecker {

}
