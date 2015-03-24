import QL.AST.Statements.statement as statement


class Assignment(statement.IStatement):

    #
    # override methods of statement
    #

    # init
    def __init__(self, qid, qtype, expression):
        self.id = qid
        self.type = qtype
        self.expression = expression

    # pretty print ast, with level giving the indentation
    def string_presentation(self, level=0):
        s = "\n" + "   " * level + "Assignment\n"
        s += "   " * (level + 1) + "Assignment id: " + self.id + "\n"
        s += "   " * (level + 1) + "Assignment itself: " + str(self.expression) + "\n"
        s += "   " * (level + 1) + "Assignment type: " + str(self.type) + "\n"
        return s

    # return all ids in the statement
    def id_collection(self):
        return [self.id]

    # return all labels in the statement
    def label_collection(self):
        return []

    # return if the statement is a conditional
    def is_conditional(self):
        return False

    # return all the dependencies in the statement of other statements
    # TODO: debug this
    def dependency_collection(self, dependencies):
        if self.id not in dependencies:
            dependencies[self.id] = self.expression.get_variables()
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        return {self.id: self.type}

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        return {self.id: self}

    def valid_expression_messages(self, type_map):
        return self.expression.is_valid_expression_message(type_map)

    def get_expression(self):
        return self.expression

    def get_id(self):
        return self.id

    def get_type_string(self):
        return self.type

    def get_label(self):
        return ""

    def is_assignment(self):
        return True