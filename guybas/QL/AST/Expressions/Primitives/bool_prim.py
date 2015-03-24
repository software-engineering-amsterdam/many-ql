import QL.AST.Expressions.Primitives.primitive as p


class Bool(p.Primitive):

    def __init__(self, pbool):
        self.__bool = pbool

    def __str__(self):
        return str(self.__bool)  # since the actual type is a real bool

    def return_type(self, type_dict):
        return bool

    # just the value of the bool itself
    def eval_expression(self, type_map):
        return self.__bool

