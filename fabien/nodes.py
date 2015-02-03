
class Node:
    def __init__(self, type, children=None, leaf=None):
         self.type = type

         if children:
              self.children = children
         else:
              self.children = []

         self.leaf = leaf

    def __repr__(self):
        return "Node(%s, %s, %s)" % (self.type, self.children, self.leaf)


class Question:
    def __init__(self, text, type=bool, label=None, function=None):
         self.text = text
         self.type = type
         self.label = label
         self.function = function

    def __repr__(self):
        return "Question(%s: %s)" % (self.type, self.text)
