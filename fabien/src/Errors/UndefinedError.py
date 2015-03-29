
class UndefinedError(Exception):
    def __init__(self, Node=None):
        self.node = Node

    def __str__(self):
        return "Undefined ID `%s` at line %s" % \
            (self.node, self.node.lineNr)
