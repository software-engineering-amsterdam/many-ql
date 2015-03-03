from QL.AST.Elements.element import *


class Number(Element):
    def __init__(self, number):
        self.number = number

    def return_type(self, type_dict):
        return "number"

    def pretty_print(self):
        return str(self.number)

    def get_dependencies(self):
        return []

    def as_list(self):
        return [self.number]