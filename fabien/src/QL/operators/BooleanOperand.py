
from numberTypes import numberTypes

class BooleanOperand:
    def __init__(self, left=None, right=None):
        self.left  = left
        self.right = right

    def getType(self, IDs=None):
        return "boolean"

    def checkType(self, IDs):
        leftType  = self.left.getType(IDs)
        rightType = self.right.getType(IDs)

        return leftType == rightType or \
              (leftType in numberTypes() and rightType in numberTypes())