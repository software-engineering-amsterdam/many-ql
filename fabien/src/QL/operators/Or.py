
from AndOr import AndOr

class Or(AndOr):

    def __repr__(self):
        return "%s or %s" % (self.left, self.right)
