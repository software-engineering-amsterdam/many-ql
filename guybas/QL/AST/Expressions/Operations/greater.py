import QL.AST.Expressions.Operations.equal as e


class Greater(e.Equal):

    def set_string_operator(self):
        return ">"

    def return_type(self, type_map):
        return bool

    def eval(self, x, y):
        return x > y