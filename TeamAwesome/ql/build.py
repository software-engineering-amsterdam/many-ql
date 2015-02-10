import os
import test
import test_expr

os.system('java org.antlr.v4.Tool -Dlanguage=Python3 QL.g4');
test.main()
print('-' * 50)
test_expr.main()
