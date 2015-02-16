
class Branch:
    def __init__(self, expression=None, ifChildren=None, elseChildren=None):
        self.expression = expression

        if ifChildren:
            self.ifChildren = ifChildren
        else:
            self.ifChildren = []

        if elseChildren:
            self.elseChildren = elseChildren
        else:
            self.elseChildren = []


    def __repr__(self, nested=0):
        tree = "IF %s" % self.expression
        for node in self.ifChildren:
            tree += "\n"  + ("\t" * nested) +  " -> " + node.__repr__(nested=nested+1)

        if self.elseChildren:
            elseTree = "\n   ELSE"
            for node in self.elseChildren:
                elseTree += "\n"  + ("\t" * nested) +  " -> " + node.__repr__(nested=nested+1)

            tree += elseTree

        return tree
