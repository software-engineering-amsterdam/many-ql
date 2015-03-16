class ExpressionVisitor:
    def visitUnaryExpression(self, node):
        pass

    def visitBinaryExpression(self, node):
        pass

    def visitBoolean(self, node):
        pass

    def visitInteger(self, node):
        pass

    def visitString(self, node):
        pass

    def visitMoney(self, node):
        pass

    def visitIdentifier(self, node):
        pass
    

class StatementVisitor:
    def visitQuestionnaire(self, questionnaire):
        pass

    def visitFormStatement(self, node):
        pass

    def visitIfStatement(self, node):
        pass

    def visitQuestionStatement(self, node):
        pass