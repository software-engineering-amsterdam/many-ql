# Type Checker
import collections
import QL.Validators.expression_validator as validator


class TypeChecker:

    # initialize and execute the _type checker
    def __init__(self, form):
        self._ids = form.get_ids()
        self._labels = form.get_labels()
        self._dependencies = form.get_dependencies()
        self._expressions = form.get_expressions()
        self._type_dict = form.get_type_dict()

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
            if validator.ExpressionValidator.validator(e.return_type(type_dict)):
                continue
            else:
                messages += e.pretty_print() + " is malformed\n"
        return messages

    def is_valid_form(self):
        valid = True
        id_message = TypeChecker.check_ids(self._ids)
        if id_message != "":
            valid = False
            print(id_message)

        label_message = TypeChecker.check_labels(self._labels)
        if label_message != "":
            print(label_message)

        dependency_message = TypeChecker.check_dependencies(self._dependencies)
        if dependency_message != "":
            valid = False
            print(dependency_message)

        expression_message = TypeChecker.check_expressions(self._expressions, self._type_dict)
        if expression_message != "":
            valid = False
            print(expression_message)

        return valid