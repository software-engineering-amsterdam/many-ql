from QL.Main.mapper import *
from QL.AST.operators import *


class Processor:

    @staticmethod
    def eval_expression(expression, answers_map):
        answers_dict = answers_map.get_answers()
        # to avoid annoying (not applicable) error messages
        answers_dict['__builtins__'] = None
        try:
            result = eval(expression, answers_dict)
            return result
        except Exception as e:
            print(e)
            return False

    @staticmethod
    def export_answers(answers_map, gui):
        print("done")
        gui.close()
