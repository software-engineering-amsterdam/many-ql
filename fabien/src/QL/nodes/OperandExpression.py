
import src.QL.operators as operators

from Expression import Expression

class OperandExpression(Expression):
    def __init__(self, LexNode, operator=None, left=None, right=None):
        Expression.__init__(self, LexNode, operator, left, right)

        self._setOperation(operator)

    def _setOperation(self, operator):
        operatorTable = {
          '+' : lambda x, y : operators.Plus(x, y),
          '-' : lambda x, y : operators.Minus(x, y),
          '*' : lambda x, y : operators.Times(x, y),
          '/' : lambda x, y : operators.Division(x, y)
        }

        try:
            self._operationFn = operatorTable[operator](self.left, self.right)
        except KeyError:
            raise Exception("Unimplemented operator %s" % operator)

    def getType(self, IDs):
        if self.Operation.checkType(IDs):
            return "number"

        return False

    def __repr__(self):
        return "OperandExpression(%s %s %s)" % (self.left, self.operator, self.right)
