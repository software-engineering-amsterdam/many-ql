import QL.AST.Expressions.Primitives.primitive as e


class Number(e.Primitive):
    def __init__(self, number):
        self.__number = number

    def __str__(self):
        return str(self.__number)  # since it is a real integer

    def return_type(self, type_dict):
        return int

    # just the int value
    def eval_expression(self, type_map):
        return self.__number