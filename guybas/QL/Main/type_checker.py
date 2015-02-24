# Type Checker
import collections

from Grammar.expressions import *
from Main.exceptions import *
from Main.expression_validator import *
from AST.operators import *


class TypeChecker:

    def __init__(self, form):
        ids = form.get_ids()
        id_message = TypeChecker.check_ids(ids)

        labels = form.get_labels()
        label_message = TypeChecker.check_labels(labels)

        statements = form.get_statements()
        dependencies = form.get_dependencies()
        transitive_dependencies = TypeChecker.transitive_dependencies(dependencies)

        print("ids:")
        print(id_message)

        print("\nlabels:")
        print(label_message)

        print("\ntransitive dependencies:")
        print(transitive_dependencies)
        print("")
        TypeChecker.is_valid_expression(statements, form.get_type_dict())

    @staticmethod
    def check_duplicates(list):
        # get_dependencies for duplicates
        duplicates = [x for x, y in collections.Counter(list).items() if y > 1]
        return duplicates

    @staticmethod
    def check_ids(ids):
        duplicates = TypeChecker.check_duplicates(ids)
        if duplicates:
            return "There are duplicate ids: " + str(duplicates)
        else:
            return ids

    @staticmethod
    def check_labels(labels):
        duplicates = TypeChecker.check_duplicates(labels)
        if duplicates:
            return "There are duplicate labels: " + str(duplicates)
        else:
            return labels

    @staticmethod
    def transitive_dependencies_key(key, values, dependencies):
        for v in dependencies[key]:
            values.add(v)
            values = values.union(TypeChecker.transitive_dependencies_key(v, values, dependencies))
        return values

    @staticmethod
    def transitive_dependencies(dependencies):
        transitive_dependencies = {}
        for k in dependencies:
            transitive_dependencies[k] = TypeChecker.transitive_dependencies_key(k, set([]), dependencies)
        return transitive_dependencies

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

    @staticmethod
    def is_valid_expression(statements, type_dict):
        expressions = []
        s = []

        for x in statements:
            expressions += x.return_expressions()
        for e in expressions:
            print(ExpressionValidator.validator(e.return_type(type_dict)))