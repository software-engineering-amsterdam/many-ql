from Tests.grammar import *
from Tests.ast import *

# Execute tests

suite = unittest.TestLoader().loadTestsFromTestCase(TestBasicGrammar)
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestExpressionGrammar))
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestFactories))
suite.addTests(unittest.TestLoader().loadTestsFromTestCase(TestAST))

unittest.TextTestRunner(verbosity=2).run(suite)