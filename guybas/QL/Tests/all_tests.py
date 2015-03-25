import unittest
import QL.Tests.grammar as grammar
import QL.Tests.ast as ast
#import QL.Tests.type_checker as type_checker
import QL.Tests.expressions as expressions
# Execute tests

suite = unittest.TestLoader().loadTestsFromTestCase(grammar.Tests)
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(ast.Tests))
#suite.addTests(unittest.TestLoader().loadTestsFromTestCase(type_checker.Tests))
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(expressions.Tests))
# suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestTypeChecker))
# suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestProcessor))


unittest.TextTestRunner(verbosity=2).run(suite)