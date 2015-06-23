
import src.QL.operators as operators
from Node import Node

class UnaryExpression(Node):
    def __init__(self, LexNode=None, value=None, operator=None):
        Node.__init__(self, LexNode)

        self.value    = value
        self.operator = operator

        self._setOperation(operator)

    def _setOperation(self, operator):
        operatorTable = {
          'NOT': lambda x : operators.Not(x),
          '!'  : lambda x : operators.Not(x),

          'MIN': lambda x : operators.UMinus(x),
          '-'  : lambda x : operators.UMinus(x)
        }

        try:
            self._operationFn = operatorTable[operator](self.value)
        except KeyError:
            raise Exception("Unimplemented operator %s" % operator)

    @property
    def Operation(self):
        return self._operationFn

    def getType(self, IDs):
        return self.Operation.getType()

    def evaluate(self, answers):
        return self.Operation.evaluate(answers)

    @property
    def children(self):
        return []

    def __repr__(self):
        return "Unary(%s %s)" % (self.operator, self.value)
