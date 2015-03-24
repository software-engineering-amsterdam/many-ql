import QL.AST.Expressions.Primitives.primitive as p


class Text(p.Primitive):
    def __init__(self, text):
        self.__text = "\"" + text + "\""

    def __str__(self):
        return self.__text

    def return_type(self, type_dict):
        return str

    # evaluation is just the value of the text
    def eval_expression(self, type_map):
        return self.__text