# AST format of a question, initializing the IStatement
import QL.AST.Statements.statement as statement


class Question(statement.IStatement):

    #
    # Override methods of statement
    #

    # init
    def __init__(self, qid, qtype, label):
        self.__id = qid
        self.__label = label
        self.__type = qtype

    # pretty print ast, with level giving the indentation
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "Question\n"
        s += "   " * (level + 1) + "Question id: " + self.__id + "\n"
        s += "   " * (level + 1) + "Question itself: " + self.__label + "\n"
        s += "   " * (level + 1) + "Question type: " + self.__type
        s += "\n"
        return s

    # return all ids in the statement
    def id_collection(self):
        return [self.__id]

    # return all labels in the statement
    def label_collection(self):
        return [self.__label]

    # a question is not a conditional statement
    def is_conditional(self):
        return False

    # return all the dependencies in the statement (which are none)
    def get_dependency_collection(self, dependencies):
        if self.__id not in dependencies:
            dependencies[self.__id] = []
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        return {self.__id: self.__type}

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        return {self.__id: self}

    #
    # getters of question
    #

    def get_label(self):
        return self.__label

    def get_type(self):
        return self.__type

    def get_id(self):
        return self.__id

    # returns a message with errors if the expression is wrongly typed, here empty thus
    def valid_type_message(self, td):
        return ""



