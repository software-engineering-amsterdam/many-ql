import QL.AST.Expressions.Operations.binary_expression as b
import QL.Grammar.constants as constants
import QL.AST.Expressions.Operations.equal as e


class Greater(e.Equal):

    def set_string_operator(self):
        return ">"

    def return_type_string(self, type_map):
        return bool

    def eval(self, x, y):
        return x > y