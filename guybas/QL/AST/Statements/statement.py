# statement interface with uninitialized methods


class IStatement:

    # pretty string format ast, with level giving the indentation
    def string_presentation(self, level=0):
        raise NotImplementedError("Not implemented here")

    # return all ids in the statement
    def ids(self):
        raise NotImplementedError("Not implemented here")

    # return all labels in the statement
    def labels(self):
        raise NotImplementedError("Not implemented here")

    # return if the statement is a conditional
    def is_conditional(self):
        raise NotImplementedError("Not implemented here")

    def is_assignment(self):
        return False

    # return all the dependencies in the statement of other statements
    def dependencies(self, dependencies):
        raise NotImplementedError("Not implemented here")

    # return a dictionary of the ids as keys and types as value in the statement
    def id_type_map(self):
        raise NotImplementedError("Not implemented here")

    # Get a dictionary with ids and statements
    def id_statement_map(self):
        raise NotImplementedError("Not implemented here")

    # return the error message of type checking, empty if correct
    def expressions_type_error_messages(self, td):
        raise NotImplementedError("Not implemented here")
