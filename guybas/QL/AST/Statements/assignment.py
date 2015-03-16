import QL.AST.Statements.statement as statement


class Assignment(statement.IStatement):

    #################################
    # override method of statement  #
    #################################

    # init
    def __init__(self, qid, qtype, expression):
        self.id = qid
        self.type = qtype
        self.expression = expression

    # pretty print ast, with level giving the indentation
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "Assignment\n"
        s += "   " * (level + 1) + "Assignment id: " + self.id + "\n"
        s += "   " * (level + 1) + "Assignment itself: " + self.expression.pretty_print() + "\n"
        s += "   " * (level + 1) + "Assignment type: " + str(self.type)
        s += "\n"
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

    # return all the _dependencies in the statement of other _statements
    def get_dependency_collection(self, dependencies):
        d = self.expression.get_dependencies()
        if self.id not in dependencies:
            dependencies[self.id] = d
        else:
            dependencies[self.id] = dependencies[self.id] + self.parent_condition.get_dependencies()
        return dependencies

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        return {self.id: self.type}

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        return {self.id: self}

    ##########################
    # Methods of assignment  #
    ##########################

    # TODO: change below?

    def get_type(self):
        return self.type

    def get_id(self):
        return self.id

    def get_label(self):
        return self.expression.pretty_print()

    def valid_type_message(self):
        return True


