
class Node:
    def __init__(self, type, children=None, leaf=None):
         self.type = type

         if children:
              self.children = children
         else:
              self.children = []

         self.leaf = leaf

    def __getitem__(self, key):
        return self.children[key]

    def __len__(self):
        return len(self.children)

    def __repr__(self):
        return "Node(%s, %s,\n\t%s)\n" % (self.type, self.leaf, self.children)


class Question:
    def __init__(self, text, type=bool, label=None, function=None):
         self.text = text
         self.type = type
         self.label = label
         self.function = function

    def __repr__(self):
        return "Question(%s: %s)" % (self.type, self.text)
