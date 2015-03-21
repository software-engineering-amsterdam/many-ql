# statement interface with uninitialized methods


class IStatement:

    # pretty print ast, with level giving the indentation
    def string_presentation(self, level=0):
        raise NotImplementedError("Not implemented by sub class")

    # return all ids in the statement
    def id_collection(self):
        raise NotImplementedError("Not implemented by sub class")

    # return all labels in the statement
    def label_collection(self):
        raise NotImplementedError("Not implemented by sub class")

    # return if the statement is a conditional
    def is_conditional(self):
        raise NotImplementedError("Not implemented by sub class")

    def is_assignment(self):
        return False

    # return all the dependencies in the statement of other statements
    def get_dependency_collection(self, dependencies):
        raise NotImplementedError("Not implemented by sub class")

    # return a dictionary of the ids as keys and types as value in the statement
    def get_id_type_collection(self):
        raise NotImplementedError("Not implemented by sub class")

    # Get a dictionary with ids and statements
    def get_statement_dict(self):
        raise NotImplementedError("Not implemented by sub class")

    # return the error message of type checking, empty if correct
    def valid_expression_message(self, td):
        raise NotImplementedError("Not implemented by sub class")
