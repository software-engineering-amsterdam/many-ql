from Tests.grammar import *
from Tests.ast import *
from Tests.type_checker import *

# Execute tests

suite = unittest.TestLoader().loadTestsFromTestCase(TestBasicGrammar)
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestExpressionGrammar))
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestFactories))
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestAST))
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestTypeChecker))


unittest.TextTestRunner(verbosity=2).run(suite)