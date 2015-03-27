# AST format of a question, initializing the IStatement
import QL.AST.Statements.statement as statement


class Question(statement.IStatement):

    # init
    def __init__(self, qid, qtype, label):

        # instance variables are protected (as far as possible in Python..)
        self._id = qid
        self._label = label
        self._type = qtype

    # pretty print ast, with level giving the indentation
    def string_presentation(self, level=0):
        s = "\n" + "   " * level + "Question\n"
        s += "   " * (level + 1) + "Question id: " + self._id + "\n"
        s += "   " * (level + 1) + "Question itself: " + self._label + "\n"
        s += "   " * (level + 1) + "Question type: %s\n" % self._type.get_name()
        return s

    def ids(self):
        return [self._id]

    def labels(self):
        return [self._label]

    def is_conditional(self):
        return False

    # A question has no dependencies, expect when they were already given before (by overarching if / if-else)
    def dependencies(self, dependencies):
        if self._id not in dependencies:
            dependencies[self._id] = []
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def id_type_map(self):
        return {self._id: self._type}

    # Get a dictionary with ids and statements
    def id_statement_map(self):
        return {self._id: self}

    def get_type(self):
        return self._type

    # A questions contains no expression and thus has no error messages (used so statements can be universally treated)
    def expressions_type_error_messages(self, td):
        return []



