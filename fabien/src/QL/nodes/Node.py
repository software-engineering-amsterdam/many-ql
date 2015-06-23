
from itertools import chain, imap

class Node(object):
    def __init__(self, LexNode=None):
        self.LexNode  = LexNode

        self.tokens = {}
        self.linenumbers = []

        if LexNode:
            self.ruleName = LexNode.slice[0]
            self._collectLineNr()

    @property
    def NodeType(self):
        return self.__class__.__name__

    def findAll(self, NodeType):
        return self._find(self.__iter__(), NodeType)

    def findChildren(self, NodeType):
        return self._find(self.children, NodeType)

    def _find(self, elements, NodeType):
        found = list()
        for node in elements:
            if node.NodeType == NodeType:
                found.append(node)

        return found

    @property
    def lineNr(self):
        if min(self.linenumbers) == max(self.linenumbers):
            return min(self.linenumbers)

        return "%d - %d" % (min(self.linenumbers), max(self.linenumbers))

    def _collectLineNr(self):
        for tok in self.LexNode.slice[1:]:
            self.tokens[tok.type] = tok.value

            if hasattr(tok, 'lineno'):
                self.linenumbers.append(tok.lineno)

    @property
    def children(self):
        # Exception, as python does not provide abstract/interface
        raise Exception("Implement children attribute in %s" % self.NodeType)

    def __iter__(self):
        yield self

        for child in chain(*imap(iter, filter(None, self.children))):
            yield child

    def __repr__(self, nested=0):
        return "%s: %s" % (self.ruleName, self.tokens)
