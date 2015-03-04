from QL.AST.Elements.element import *
import QL.Grammar.constants as constants

class Bool(Element):
    def __init__(self, pbool):
        self.bool = pbool

    def return_type(self, type_dict):
        return constants.GrammarConstants.BOOL

    def pretty_print(self):
        return str(self.bool)

    def get_dependencies(self):
        return []

    def as_list(self):
        return [self.bool]