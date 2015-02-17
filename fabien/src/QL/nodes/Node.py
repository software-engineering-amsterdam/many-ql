
import pprint

class Node(object):
    def __init__(self, LexNode=None):

        self.LexNode  = LexNode
        self.ruleName = LexNode.slice[0]

        self.linenumbers = []

        # TODO default for duplicate 'keys' (i.e. multiple ID or blocks)
        self.tokens = {}
        for tok in LexNode.slice[1:]:
            self.tokens[tok.type] = tok.value


            #pprint.pprint( vars(tok) )

            # Guess Node lineNr
            if hasattr(tok, 'lineno'):
                self.linenumbers.append(tok.lineno)

    def hasChildren(self):
        return "block" in self.tokens

    @property
    def children(self):
        return self.tokens.get("block", list())

    def isClass(self, Name):
        return self.__class__.__name__ == Name

    @property
    def lineNr(self):
        if min(self.linenumbers) == max(self.linenumbers):
            return min(self.linenumbers)

        return "%d - %d" % (min(self.linenumbers), max(self.linenumbers))


    def __repr__(self, nested=0):
        return "%s: %s" % (self.ruleName, self.tokens)