import QL.AST.Expressions.Primitives.primitive as p
import QL.AST.Expressions.Types.text_type as t


class Text(p.Primitive):
    def __init__(self, text):
        self.__text = text

    def __str__(self):
        return self.__text

    def return_type(self, type_map):
        return t.Text()

    # evaluation is just the value of the text
    def eval_expression(self, answer_map):
        return self.__text