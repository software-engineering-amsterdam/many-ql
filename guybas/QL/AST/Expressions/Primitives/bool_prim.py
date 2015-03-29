import QL.AST.Expressions.Primitives.primitive as primitive
import QL.AST.Expressions.Types.bool_type as bool_type


class Bool(primitive.Primitive):

    def __init__(self, pbool):
        self.__bool = pbool

    def __str__(self):
        return str(self.__bool)  # since the actual type is a real bool

    def return_type(self, type_map):
        return bool_type.Bool()

    # just the value of the bool itself
    def eval_expression(self, answer_map):
        return self.__bool

