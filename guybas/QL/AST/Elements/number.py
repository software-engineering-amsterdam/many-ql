from QL.AST.Elements.element import *
import QL.Grammar.constants as constants

class Number(Element):
    def __init__(self, number):
        self.number = number

    def return_type(self, type_dict):
        return constants.GrammarConstants.NUMBER

    def pretty_print(self):
        return str(self.number)

    def get_dependencies(self):
        return []

    def as_list(self):
        return [self.number]