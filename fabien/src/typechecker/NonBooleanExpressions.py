
# Typechecker
#   Numbers  -> values
#   Literals -> ?
#   ID       -> Build lookup table of type
#  evaluate OperandExpr -> return Evaluate Left, evaluate Right?
#           number/literal/ID -> return type?

class NonBooleanExpressions():
    def __init__(self):
        self.errors = []

    def Branch(self, node):
        if not node.isValidExpression():
            self.errors += node