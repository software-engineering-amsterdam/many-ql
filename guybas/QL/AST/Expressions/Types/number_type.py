import QL.AST.Expressions.Types.type_interface as type_interface


class Number(type_interface.Type):
    def __init__(self):
        self.name = "number"