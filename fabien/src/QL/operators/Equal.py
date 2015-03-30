
from BooleanOperand import BooleanOperand

class Equal(BooleanOperand):
    def evaluate(self, answers):
        return self.left.evaluate(answers) == self.right.evaluate(answers)

    def __repr__(self):
        return "%s == %s" % (self.left, self.right)
