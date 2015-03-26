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
        s += "   " * (level + 1) + "Assignment type: " + self.__type.get_name() + "\n"
        return s

    # return all ids in the statement
    def ids(self):
        return [self.__id]

    # return all labels in the statement
    def labels(self):
        return []

    # return if the statement is a conditional
    def is_conditional(self):
        return False

    # evaluate the expression given the map of ids to answers
    def evaluate_expression(self, answer_map):
        return self.__expression.eval_expression(answer_map)

    # return all the dependencies in the statement of other statements
    def dependencies(self, dependencies):
        if self.__id not in dependencies:
            dependencies[self.__id] = self.__expression.get_variables()
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def id_to_type_map(self):
        return {self.__id: self.__type}

    # Get a dictionary with ids and statements
    def id_statement_map(self):
        return {self.__id: self}

    def valid_expression_messages(self, type_map):
        return self.__expression.type_error_messages(type_map)

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