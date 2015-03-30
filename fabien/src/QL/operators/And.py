
from AndOr import AndOr

class And(AndOr):
    def evaluate(self, answers):
        return self.left.evaluate(answers) and \
               self.right.evaluate(answers)

    def __repr__(self):
        return "%s and %s" % (self.left, self.right)
