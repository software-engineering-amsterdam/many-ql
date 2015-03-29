
from itertools import chain, imap

class Node(object):
    def __init__(self, LexNode=None):

        self.LexNode  = LexNode
        self.ruleName = LexNode.slice[0]

        self.linenumbers = []

        # TODO default for duplicate 'keys' (i.e. multiple ID or blocks)

        self.tokens = {}
        for tok in LexNode.slice[1:]:
            self.tokens[tok.type] = tok.value

            if hasattr(tok, 'lineno'):
                self.linenumbers.append(tok.lineno)

    @property
    def NodeType(self):
        return self.__class__.__name__

    @property
    def lineNr(self):
        if min(self.linenumbers) == max(self.linenumbers):
            return min(self.linenumbers)

        return "%d - %d" % (min(self.linenumbers), max(self.linenumbers))

    def __iter__(self):
        yield self

        for child in chain(*imap(iter, filter(None, self.children))):
            yield child

    @property
    def children(self):
        # Exception, as python does not provide abstract/interface
        raise Exception("Implement children attribute in %s" % self.NodeType)

    def __repr__(self, nested=0):
        return "%s: %s" % (self.ruleName, self.tokens)
