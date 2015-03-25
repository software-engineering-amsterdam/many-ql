import QL.AST.Statements.statement as statement


class Assignment(statement.IStatement):

    #
    # override methods of statement
    #

    # init
    def __init__(self, qid, qtype, expression):
        self.__id = qid
        self.__type = qtype
        self.__expression = expression

    # pretty print ast, with level giving the indentation
    def string_presentation(self, level=0):
        s = "\n" + "   " * level + "Assignment\n"
        s += "   " * (level + 1) + "Assignment id: " + self.__id + "\n"
        s += "   " * (level + 1) + "Assignment itself: " + str(self.__expression) + "\n"
        s += "   " * (level + 1) + "Assignment type: " + str(self.__type) + "\n"
        return s

    # return all ids in the statement
    def id_collection(self):
        return [self.__id]

    # return all labels in the statement
    def label_collection(self):
        return []

    # return if the statement is a conditional
    def is_conditional(self):
        return False

    # evaluate the expression given the map of ids to answers
    def evaluate_expression(self, answer_map):
        return self.__expression.eval_expression(answer_map)

    # return all the dependencies in the statement of other statements
    # TODO: debug this
    def dependency_collection(self, dependencies):
        if self.__id not in dependencies:
            dependencies[self.__id] = self.__expression.get_variables()
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        return {self.__id: self.__type}

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        return {self.__id: self}

    def valid_expression_messages(self, type_map):
        return self.__expression.is_valid_messages(type_map)

    def get_expression(self):
        return self.__expression

    def get_id(self):
        return self.__id

    def get_type_string(self):
        return self.__type

    def get_label(self):
        return ""

    def is_assignment(self):
        return True