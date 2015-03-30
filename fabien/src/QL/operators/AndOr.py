
from BooleanOperand import BooleanOperand

from numberTypes import numberTypes

class AndOr(BooleanOperand):

    def checkType(self, IDs):
        leftType  = self.left.getType(IDs)
        rightType = self.right.getType(IDs)

        return leftType  == "boolean" or \
               rightType == "boolean" or \
               leftType  == rightType or \
               leftType in numberTypes() and \
               rightType in numberTypes()