
from Node import Node

class UnaryExpression(Node):
    def __init__(self, value=None, operator=None):
         self.value    = value
         self.operator = operator

    def getType(self, IDs=None):
        if self.operator == "MIN":
          return "number"
        elif self.operator == "NOT":
          return "boolean"

        return False

    def checkType(self, IDs):
        return self.getType(IDs)

    @property
    def children(self):
        return []

    def __repr__(self):
        return "Unary(%s %s)" % (self.operator, self.value)
