from Main.mapper import *
from AST.operators import *


class Processor:
    @staticmethod
    def update_expression(expression, answers_map):
        answers_dict = answers_map.get_answers()
        # to avoid annoying (not applicable) error messages
        answers_dict['__builtins__'] = None
        print(expression)
        try:
            result = eval(expression, answers_dict)
            print(result)
            print("it worked")
            return result
        except NameError:
            print("Error")
            return False
        except:
            print("Unknown error")
            return False

    @staticmethod
    def conditions_proc(expression, answers_map):
        """
        This function will convert the expression identifiers into
        parameters and will get_dependencies whether the expression is True or False
        :param list expression: the if condition content
        :param Mapper answers_map: mapper object with the question ids and their corresponding answers
        :return: bool
        """
        # bind ids to values
        #simplified_c = Processor.bind_values(expression, answers_map)

        # process the expression, and return true/false
        result = Processor.update_expression(expression, answers_map)
        if result:
            return True
        else:
            return False

    @staticmethod
    def extract_variables(expression):
        vars = []
        for e in expression:
            if not isinstance(e, Variable):
                continue
            vars.append(str(e))
        return vars