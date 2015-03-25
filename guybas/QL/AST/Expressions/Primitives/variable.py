import QL.AST.Expressions.Primitives.primitive as p


class Variable(p.Primitive):
    def __init__(self, name):
        self.__name = name

    # return the type name (string) of the variable
    # we need to check if the variable exists because the type checking continuous even if other errors have been found
    def return_type(self, type_map):
        if self.__name not in type_map:
            return None
        return type_map[self.__name]

    def __str__(self):
        return self.__name

    # The variables are the variable itself
    def get_variables(self):
        return [self.__name]

    # evaluate the primitive, in this case the value in the answer_map given (if existent)
    def eval_expression(self, answer_map):
        if answer_map.exists(self.__name):
            return answer_map.get_answer_by_id(self.__name)
        return None