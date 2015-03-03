
from AndOr import AndOr

class And(AndOr):

    def __repr__(self):
        return "%s and %s" % (self.left, self.right)
