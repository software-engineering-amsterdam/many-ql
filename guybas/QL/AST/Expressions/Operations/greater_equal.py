import QL.AST.Expressions.Operations.equal as e
import QL.Grammar.constants as constants


class GreaterEqual(e.Equal):

    def set_operator(self):
        return " >= "

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        return constants.BOOL

    def eval(self, x, y):
        return x >= y