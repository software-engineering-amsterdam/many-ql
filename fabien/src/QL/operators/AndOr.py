
from BooleanOperand import BooleanOperand

class AndOr(BooleanOperand):

    def checkType(self, IDs):
        leftType  = self.left.getType(IDs)
        rightType = self.right.getType(IDs)

        numberTypes = ["number", "int", "float", "money"]

        return leftType  == "boolean" or \
               rightType == "boolean" or \
               leftType  == rightType or \
               leftType in numberTypes and rightType in numberTypes