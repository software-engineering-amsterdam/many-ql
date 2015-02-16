
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

    def __repr__(self, nested=0):
        tree = "Node(%s, %s)" % (self.type, self.leaf)

        for node in self.children:
            tree += "\n"  + ("\t" * nested) +  " -> " + node.__repr__(nested=1)

        return tree

class Question:
    def __init__(self, text, type=bool, label=None, function=None):
         self.text = text
         self.type = type
         self.label = label
         self.function = function

    def __repr__(self, nested=0):
        return "Question(%s: %s)" % (self.type, self.text)


class Expression:
    def __init__(self, leaf=None, left=None, right=None):
         self.leaf  = leaf

         self.left  = left
         self.right = right

    def __repr__(self, nested=0):
        return "Expression(%s %s %s)" % (self.left, self.leaf, self.right)

