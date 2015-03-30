
import src.QL.operators as operators

from Expression import Expression

class BooleanExpression(Expression):
    def __init__(self, LexNode, operator=None, left=None, right=None):
        Expression.__init__(self, LexNode, operator, left, right)

        self._setOperation(operator)

    def _setOperation(self, operator):
        operatorTable = {
          '>'  : lambda x, y : operators.GreaterThan(x, y),
          '<'  : lambda x, y : operators.LessThan(x, y),

          '!=' : lambda x, y : operators.NotEqual(x, y),
          '==' : lambda x, y : operators.Equal(x, y),
          '>=' : lambda x, y : operators.GreaterOrEqual(x, y),
          '<=' : lambda x, y : operators.LessOrEqual(x,y),

          'or' : lambda x, y : operators.Or(x,y),
          '||' : lambda x, y : operators.Or(x,y),

          'and' : lambda x, y : operators.And(x,y),
          '&&'  : lambda x, y : operators.And(x,y)
        }

        try:
            self._operationFn = operatorTable[operator](self.left, self.right)
        except KeyError:
            raise Exception("Unimplemented operator %s" % operator)


    def getType(self, IDs):
        if self.Operation.checkType(IDs):
            return "boolean"

        return False

    def __repr__(self):
        return "BooleanExpression(%s %s %s)" % (self.left, self.operator, self.right)

