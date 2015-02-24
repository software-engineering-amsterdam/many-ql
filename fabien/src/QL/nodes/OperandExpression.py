
from Expression import Expression

class OperandExpression(Expression):
    def __init__(self, LexNode, operator=None, left=None, right=None):
        Expression.__init__(self, LexNode, operator=None, left=None, right=None)

        self.operator = operator

        self.left  = left
        self.right = right

    def __repr__(self):
        return "Operand Expression(%s %s %s)" % (self.left, self.operator, self.right)

