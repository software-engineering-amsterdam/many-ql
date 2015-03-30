
from AndOr import AndOr

class Or(AndOr):
    def evaluate(self, answers):
        return self.left.evaluate(answers) or \
               self.right.evaluate(answers)

    def __repr__(self):
        return "%s or %s" % (self.left, self.right)
