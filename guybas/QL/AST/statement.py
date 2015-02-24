# statement interface with uninitialized methods


class IStatement:

    # init
    def __init__(self):
        pass

    # pretty print ast, with level giving the identation
    def pretty_print(self, level = 0):
        pass

    # return all ids in the statement
    def id_collection(self):
        pass

    # return all labels in the statement
    def label_collection(self):
        pass

    # return if the statement is a conditional
    def is_conditional(self):
        pass

    # return all the dependencies in the statement of other _statements
    def dependency_collection(self, dependencies):
        pass

    def return_expressions(self):
        pass

    def set_parent_id(self, pid):
        pass