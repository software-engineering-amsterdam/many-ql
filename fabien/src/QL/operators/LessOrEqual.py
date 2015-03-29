
from NumericOperand import NumericOperand

class LessOrEqual(NumericOperand):
    def evaluate(self, answers):
        return self.left.evaluate(answers) <= \
               self.right.evaluate(answers)


    def getType(self, IDs=None):
        return "boolean"

    def __repr__(self):
        return "%s <= %s" % (self.left, self.right)
