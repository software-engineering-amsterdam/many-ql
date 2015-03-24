import QL.AST.Expressions.Operations.binary_expression as b
import QL.Grammar.constants as constants


class And(b.BinaryExpression):

    def set_string_operator(self):
        return " and "

    # get the return _type of the _expression
    def return_type_string(self, type_map):
        return bool

    def eval(self, x, y):
        return x and y