from QL.AST.Elements.element import *

class Variable(Element):
    def __init__(self, name):
        self.name = name

    def pretty_print(self):
        return str(self.name)

    def return_type(self, type_dict):
        return type_dict[self.name]

    def pretty_print(self):
        return self.name

    def get_dependencies(self):
        return [self.name]

    def as_list(self):
        return [self.name]