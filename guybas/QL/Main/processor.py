from Main.mapper import *


class Processor:
    @staticmethod
    def conditions_proc(expression, answers_map):
        """
        This function will convert the expression identifiers into
        parameters and will check whether the expression is True or False
        :param list expression: the if condition content
        :param Mapper answers_map: mapper object with the question ids and their corresponding answers
        :return: bool
        """
        # verify that the format is as expected
        if not TypeChecker.type_checker(expression, 'list'):
            raise QException('ComplexExpression is not a list!')

        # bind ids to values
        simplified_c = Processor.bind_values(expression, answers_map)

        # process the expression, and return true/false
        result = eval(simplified_c)
        if result:
            return True
        return False

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