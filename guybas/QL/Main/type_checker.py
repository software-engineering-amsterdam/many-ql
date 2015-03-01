# Type Checker
import collections

from Main.exceptions import *
from AST.expression_validator import *
from Grammar.basic_types import *


class TypeChecker:

    # initialize and execute the type checker
    def __init__(self, form):
        ids = form.get_ids()
        id_message = TypeChecker.check_ids(ids)
        if id_message != "":
            print(id_message)

        labels = form.get_labels()
        label_message = TypeChecker.check_labels(labels)
        if label_message != "":
            print(label_message)

        dependencies = form.get_dependencies()
        dependency_message = TypeChecker.check_dependencies(dependencies)
        if dependency_message != "":
            print(dependency_message)

        expressions = form.get_expressions()
        expression_message = TypeChecker.check_expressions(expressions, form.get_type_dict())
        if expression_message != "":
            print(expression_message)

    # All static methods to check if ids and labels contain duplicates, there are no circle dependencies,
    # and expressions are well formed
    @staticmethod
    def check_duplicates(l):
        # get_dependencies for duplicates
        duplicates = [x for x, y in collections.Counter(l).items() if y > 1]
        return duplicates

    @staticmethod
    def check_ids(ids):
        duplicates = TypeChecker.check_duplicates(ids)
        if duplicates:
            return "There are duplicate ids: " + str(duplicates)
        else:
            return ""

    @staticmethod
    def check_labels(labels):
        duplicates = TypeChecker.check_duplicates(labels)
        if duplicates:
            return "There are duplicate labels: " + str(duplicates)
        else:
            return ""

    @staticmethod
    def check_dependencies(dependencies):
        message = ""
        for d in dependencies:
            if d in dependencies[d]:
                message += str(d) + " is dependent on itself"
        return message

    @staticmethod
    def check_expressions(expressions, type_dict):
        messages = ""
        for e in expressions:
            if ExpressionValidator.validator(e.return_type(type_dict)):
                continue
            else:
                messages += e.pretty_print() + " is malformed"
        return messages

    # TODO: try to make this obsolete
    @staticmethod
    def type_checker(cinput, ctype=False):
        """
        This function allows to return the input type or to compare input type
        with pre-defined type
        :param int|str|boolean|list|float|complex cinput: the input to get_dependencies
        :param str|bool ctype: The expected type to compare with, False to return the input type
        :return: True|False|str
        """
        if isinstance(cinput, bool):  # bool class is a subclass of int class
            type_class = BasicTypes.bool_name
        elif isinstance(cinput, (int, float)):  # in python3 int = long
            type_class = BasicTypes.number_name
        elif isinstance(cinput, str):  # text str is a subclass of list class
            type_class = BasicTypes.text_name
            # str could be int
            if cinput.isdigit():
                type_class = BasicTypes.number_name
        elif isinstance(cinput, list):
            type_class = BasicTypes.list_name
        elif isinstance(cinput, Operator):
            type_class = Expressions.operator_name
        else:
            raise QException("Undefined input " + str(type(cinput)))

        if not ctype:
            return type_class

        if ctype is type_class:
            return True
        elif ctype is BasicTypes.text_name and type_class is BasicTypes.number_name:  # text could be number
            return True
        return False