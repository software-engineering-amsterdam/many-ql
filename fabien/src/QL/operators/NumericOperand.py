
from numberTypes import numberTypes

class NumericOperand:
    def __init__(self, left=None, right=None):
        self.left  = left
        self.right = right

    def getType(self, IDs=None):
        return "number"

    def checkType(self, IDs):
        leftType  = self.left.getType(IDs)
        rightType = self.right.getType(IDs)

        return leftType in numberTypes() and \
               rightType in numberTypes()