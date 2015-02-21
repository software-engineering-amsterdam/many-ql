# Type Checker
import collections

from Grammar.expressions import *
from Main.exceptions import *


class TypeChecker:

    def __init__(self, form):
        self.form = form
        ids = TypeChecker.check_ids(self.form.statements)
        labels = TypeChecker.check_labels(self.form.statements)
        dependencies = TypeChecker.check_dependencies(self.form.statements)
        transitive_dependencies = TypeChecker.transitive_dependencies(dependencies)

        print("ids:")
        print(ids)

        print("labels:")
        print(labels)

        print("transitive dependencies:")
        print(transitive_dependencies)
        print("")
        TypeChecker.is_valid_expression(self.form.statements)

    @staticmethod
    def check_duplicates(list):
        # get_dependencies for duplicates
        duplicates = [x for x, y in collections.Counter(list).items() if y > 1]
        return duplicates

    @staticmethod
    def check_ids(questions):
        ids = []
        for question in questions:
            ids += (question.id_collection())
        duplicates =  TypeChecker.check_duplicates(ids)
        if duplicates:
            print("There are duplicate ids: " + str(duplicates))
        return ids

    @staticmethod
    def check_labels(questions):
        labels = []
        for question in questions:
            labels += question.label_collection()
        duplicates = TypeChecker.check_duplicates(labels)
        if duplicates:
            print("There are duplicate labels: " + str(duplicates))
        return labels

    @staticmethod
    def check_dependencies(statements):
        dependencies = {}
        for x in statements:
            new_dependencies = x.dependency_collection({})
            dependencies = dict(list(dependencies.items()) + list(new_dependencies.items()))
        return dependencies

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

    @staticmethod
    def type_checker(cinput, ctype=False):
        """
        This function allows to return the input type or to compare input type
        with pre-defined type
        :param int|str|boolean|list|float|complex cinput: the input to get_dependencies
        :param str|bool ctype: The expected type to compare with, False to return the input type
        :return: True|False|str
        """
        if isinstance(cinput, str):
            type_class = BasicTypes.text_name
        elif isinstance(cinput, (int, float, complex)):  # in python 3 int = long
            type_class = BasicTypes.number_name
        elif isinstance(cinput, bool):
            type_class = BasicTypes.bool_name
        elif isinstance(cinput, list):
            type_class = BasicTypes.listName
        elif isinstance(cinput, Operator):
            type_class = Expressions.operator_name
        else:
            raise QException("Undefined input.")

        if ctype and ctype is type_class:
            return True
        elif ctype:
            return False
        return type_class

    @staticmethod
    def is_valid_expression(statements):
        expressions = []
        s = []
        for x in statements:
            expressions += x.return_expressions()
        for e in expressions:
            e.return_type()
