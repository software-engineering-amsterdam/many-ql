# AST for expressions
from QL.Grammar.expressions import *


# Expression interface
class Expression:
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    def return_type(self, type_dict):
        raise NotImplementedError("Not implemented by sub class")

    def pretty_print(self):
        raise NotImplementedError("Not implemented by sub class")

    def get_dependencies(self):
        raise NotImplementedError("Not implemented by sub class")

    def as_list(self):
        raise NotImplementedError("Not implemented by sub class")





