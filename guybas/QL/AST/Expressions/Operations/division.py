import QL.AST.Expressions.Primitives.primitive as e
import QL.Grammar.constants as constants


class Division(e.Primitive):

    def set_operator(self):
        return " / "

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        return constants.NUMBER

    def eval(self, x, y):
        return x / y