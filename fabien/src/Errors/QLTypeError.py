
class QLTypeError(Exception):
    def __init__(self, Node=None, message=""):
        self.node = Node
        self.message = message

    def __str__(self):
        return "TypeError with `%s`: %s at line %s" % \
            (self.node.Operation, self.message, self.node.lineNr)
