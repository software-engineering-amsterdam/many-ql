
class Form:
    def __init__(self, name="", children=None):
         self.name = name

         if children:
            self.children = children
         else:
            self.children = []


    def __getitem__(self, key):
        return self.children[key]

    def __len__(self):
        return len(self.children)

    def __repr__(self, nested=0):
        tree = "Form %s" % self.name

        for node in self.children:
            tree += "\n"  + ("\t" * nested) +  " -> " + node.__repr__(nested=nested+1)

        return tree
