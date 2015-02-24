from Main.mapper import *
from AST.operators import *


class Processor:
    @staticmethod
    def update_expression(expression, answers_map):
        answers_dict = answers_map.get_answers()
        print("!!")

        # to avoid annoying (not applicable) error messages
        answers_dict['__builtins__'] = None

        print(expression)
        print(answers_dict)
        try:
            result = eval(expression, answers_dict)
            return result
        except:
            print("hello?")
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
        #Processor.update_expression(expression, answers_map)
        variables = None
        result = False #eval(expression, variables)
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

    @staticmethod
    def bind_values(expression, answers_map):
        """
        This functions replace ids with their values as defined in the map
        :param list expression: the if condition content
        :param Mapper answers_map: mapper object with the question ids and their corresponding answers
        :return str: expression
        """
        s = ''
        for e in expression:
            if TypeChecker.type_checker(e, 'list'):  # is a sub condition? go recursive!
                s += ' ' + Processor.bind_values(e, answers_map) + ' '
            elif TypeChecker.type_checker(e, 'text'):  # is it a text? it must be an Id !
                if answers_map.id_exists(e):  # does this id exists?
                    s += ' ' + answers_map.get_answer_by_id(e) + ' '  # bind value to the id
                else:  # if no answer input entered yet, define as empty
                    s += ' None '
            else:
                s += ' ' + str(e) + ' '
        return s