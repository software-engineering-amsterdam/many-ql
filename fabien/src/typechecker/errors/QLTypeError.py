
class QLTypeError:
    def __init__(self, Node=None, message=None):
        self.node = Node
        self.message = message

        if not Node.left:
            self.lineno = Node.lineNr
        else:
            self.lineno = Node.left.lineNr

    def __str__(self):
        return "TypeError with `%s`: %s at line %s" % \
            (self.node, self.message, self.lineno)
