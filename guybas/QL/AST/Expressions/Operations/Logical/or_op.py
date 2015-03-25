import QL.AST.Expressions.Operations.binary_expression as b
import QL.AST.Expressions.Types.bool_type as t


class Or(b.BinaryExpression):

    def set_string_operator(self):
        return "or"

    def return_type(self, type_map):
        return t.Bool()

    def concrete_eval(self, x, y):
        return x or y