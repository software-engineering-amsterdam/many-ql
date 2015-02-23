package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.typechecker.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestAdd.class,
   TestArithmetic.class,
   TestEq.class,
   TestForm.class,
   TestIf.class,
   TestNEq.class,
   TestOrAnd.class,
   TestRelational.class,
   TestIdentifier.class,
   TestCompatibility.class
})
public class TestTypeChecker {
}
