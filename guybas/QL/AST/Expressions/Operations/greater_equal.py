import QL.AST.Expressions.Operations.equal as e


class GreaterEqual(e.Equal):

    def set_string_operator(self):
        return " >= "

    # get the return _type of the _expression
    def return_type(self, type_map):
        return bool

    def eval(self, x, y):
        return x >= y