# AST format of a question, initializing the IStatement
import QL.AST.Statements.statement as statement


class Question(statement.IStatement):

    #
    # Override methods of statement
    #

    # init
    def __init__(self, qid, qtype, label):
        self._id = qid
        self._label = label
        self._type = qtype

    # pretty print ast, with level giving the indentation
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "Question\n"
        s += "   " * (level + 1) + "Question id: " + self._id + "\n"
        s += "   " * (level + 1) + "Question itself: " + self._label + "\n"
        s += "   " * (level + 1) + "Question type: " + str(self._type.pretty_print())
        s += "\n"
        return s

    # return all ids in the statement
    def id_collection(self):
        return [self._id]

    # return all labels in the statement
    def label_collection(self):
        return [self._label]

    def is_conditional(self):
        return False

    # return all the _dependencies in the statement of other _statements
    def get_dependency_collection(self, dependencies):
        if self._id not in dependencies:
            dependencies[self._id] = []
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        return {self._id: self._type.pretty_print()}

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        return {self._id: self}

    #
    # getters of question
    #

    def get_label(self):
        return self._label

    def get_type(self):
        return self._type.pretty_print()

    def get_id(self):
        return self._id

    def valid_type(self, td):
        return True



