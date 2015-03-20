package test.ql;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.ql.typechecker.TestArithmetic;
import test.ql.typechecker.TestCompatibility;
import test.ql.typechecker.TestIdentifier;
import test.ql.typechecker.TestLiteral;
import test.ql.typechecker.TestRelational;
import test.ql.typechecker.TestStatement;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestArithmetic.class,
   TestLiteral.class,
   TestStatement.class,
   TestRelational.class,
   TestIdentifier.class,
   TestCompatibility.class
})
public class TestTypeChecker {
}
