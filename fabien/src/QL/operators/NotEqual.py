
class NotEqual():
    def __init__(self, left=None, right=None):
        self.left  = left
        self.right = right

    def getType(self, IDs=None):
        return "boolean"

    # Anything can be not equal?
    def checkType(self, IDs):
        return True

    def __repr__(self):
        return "%s != %s" % (self.left, self.right)
