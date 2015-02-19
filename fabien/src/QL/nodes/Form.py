
from Node import Node

class Form(Node):

    def __init__(self, LexNode):
        Node.__init__(self, LexNode)

        self.name     = self.tokens.get('ID', "")


    def __repr__(self, nested=0):
        tree = "Form %s" % self.name

        for child in self.children:
            tree += "\n"  + ("\t" * nested) +  " -> " + child.__repr__(nested=nested+1)

        return tree