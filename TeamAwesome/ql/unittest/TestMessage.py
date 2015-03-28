from ql.typechecking import Message



class Factory(Message.Factory):
    def duplicateLabel(self, label, lineNumber):
        return {
            'message' : 'duplicateLabel',
            'label' : label,
            'lineNumber' : lineNumber
        }


    def questionCycle(self, questionCycle, lineNumber):
        return {
            'message' : 'questionCycle',
            'questionCycle' : questionCycle,
            'lineNumber' : lineNumber
        }


    def questionRedefinition(
        self, question, actualType, expectedType, lineNumber
    ):
        return {
            'message' : 'questionRedefinition',
            'question' : question,
            'actualType' : actualType,
            'expectedType' : expectedType,
            'lineNumber' : lineNumber
        }


    def incompatibleExpressionType(
        self, actualType, allowedTypes, lineNumber
    ):
        return {
            'message' : 'incompatibleExpressionType',
            'actualType' : actualType,
            'allowedTypes' : allowedTypes,
            'lineNumber' : lineNumber
        }


    def undeclaredIdentifier(self, identifier, lineNumber):
        return {
            'message' : 'undeclaredIdentifier',
            'identifier' : identifier,
            'lineNumber' : lineNumber
        }


    def invalidOperands(self, operator, operands, lineNumber):
        return {
            'message' : 'invalidOperands',
            'operator' : operator,
            'operands' : operands,
            'lineNumber' : lineNumber
        }