import QL.AST.Statements.statement as statement


class Assignment(statement.IStatement):

    # init
    def __init__(self, qid, qtype, expression):

        # protected instance variables
        self._id = qid
        self._type = qtype
        self._expression = expression

    # pretty formatted string, with level giving the indentation
    def string_presentation(self, level=0):
        s = "\n" + "   " * level + "Assignment\n"
        s += "   " * (level + 1) + "Assignment id: " + self._id + "\n"
        s += "   " * (level + 1) + "Assignment itself: " + str(self._expression) + "\n"
        s += "   " * (level + 1) + "Assignment type: " + self._type.get_name() + "\n"
        return s

    def ids(self):
        return [self._id]

    # assignment has no labels
    def labels(self):
        return []

    def is_conditional(self):
        return False

    # evaluate the expression given the map of ids to answers
    def evaluate_expression(self, answer_map):
        return self._expression.eval_expression(answer_map)

    # return all the dependencies in the statement of other statements
    def dependencies(self, dependencies):
        if self._id not in dependencies:
            dependencies[self._id] = self._expression.get_variables()
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def id_type_map(self):
        return {self._id: self._type}

    # Get a dictionary with ids and statements
    def id_statement_map(self):
        return {self._id: self}

    def expressions_type_error_messages(self, type_map):
        return self._expression.type_error_messages(type_map)

    def get_expression(self):
        return self._expression

    def get_id(self):
        return self._id

    def get_type_string(self):
        return self._type

    def get_label(self):
        return ""

    def is_assignment(self):
        return True