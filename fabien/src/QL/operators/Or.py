
from BooleanOperand import BooleanOperand

class Or(BooleanOperand):

    def checkType(self, IDs):
        leftType  = self.left.getType(IDs)
        rightType = self.right.getType(IDs)

        numberTypes = ["number", "int", "float", "money"]

        return leftType  == "boolean" or \
               rightType == "boolean" or \
               leftType  == rightType or \
               leftType in numberTypes and rightType in numberTypes

    def __repr__(self):
        return "%s or %s" % (self.left, self.right)
