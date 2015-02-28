from Main.mapper import *
from AST.operators import *


class Processor:

    @staticmethod
    def eval_expression(expression, answers_map):
        answers_dict = answers_map.get_answers()
        # to avoid annoying (not applicable) error messages
        answers_dict['__builtins__'] = None
        try:
            result = eval(expression, answers_dict)
            print(result)
            print("Evaluate to true")
            return result
        except NameError:
            print("Variable not initialized yet")
            return False
        except:
            print("Unknown error")
            return False

    @staticmethod
    def extract_variables(expression):
        vars = []
        for e in expression:
            if not isinstance(e, Variable):
                continue
            vars.append(str(e))
        return vars