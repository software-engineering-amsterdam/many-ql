class Factory:
    def duplicateLabel(self, label, lineNumber):
        pass


    def questionCycle(self, questionCycle, lineNumber):
        pass


    def questionRedefinition(
        self, question, actualType, expectedType, lineNumber
    ):
        pass


    def incompatibleExpressionType(
        self, actualType, allowedTypes, lineNumber
    ):
        pass


    def undeclaredIdentifier(self, identifier, lineNumber):
        pass
        

    def invalidOperands(self, operator, operands, lineNumber):
        pass