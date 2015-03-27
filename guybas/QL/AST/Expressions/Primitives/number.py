import QL.AST.Expressions.Primitives.primitive as primitive
import QL.AST.Expressions.Types.number_type as number_type


class Number(primitive.Primitive):
    def __init__(self, number):
        self.__number = number

    def __str__(self):
        return str(self.__number)  # since it is a real integer

    def return_type(self, type_map):
        return number_type.Number()

    # just the int value
    def eval_expression(self, answer_map):
        return self.__number