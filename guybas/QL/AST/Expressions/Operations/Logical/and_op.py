import QL.AST.Expressions.Operations.binary_expression as b
import QL.AST.Expressions.Types.bool_type as t


class And(b.BinaryExpression):

    def set_string_operator(self):
        return "and"

    # get the return _type of the _expression
    def return_type(self, type_map):
        return t.Bool()

    def concrete_eval(self, x, y):
        return x and y