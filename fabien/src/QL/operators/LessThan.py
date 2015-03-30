
from NumericOperand import NumericOperand

class LessThan(NumericOperand):
    def evaluate(self, answers):
        return int(self.left.evaluate(answers)) < \
               int(self.right.evaluate(answers))

    def getType(self, IDs=None):
        return "boolean"

    def __repr__(self):
        return "%s < %s" % (self.left, self.right)
