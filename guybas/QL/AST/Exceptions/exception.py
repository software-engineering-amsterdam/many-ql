import QL.AST.Exceptions.warning as w


class TypeException(w.TypeWarning):

    def print_message(self):
        print("Error: (" + self.category + "): " + self.message)