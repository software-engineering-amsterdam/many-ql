import QL.AST.Expressions.Primitives.primitive as primitive
import QL.AST.Expressions.Types.text_type as text_type


class Text(primitive.Primitive):
    def __init__(self, text):
        self.__text = text

    def __str__(self):
        return self.__text

    def return_type(self, type_map):
        return text_type.Text()

    # evaluation is just the value of the text
    def eval_expression(self, answer_map):
        return self.__text