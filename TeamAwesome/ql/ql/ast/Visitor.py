class ExpressionVisitor:
    def visitUnaryExpressionBegin(self, node):
        pass


    def visitUnaryExpressionEnd(self, node):
        pass


    def visitBinaryExpressionBegin(self, node):
        pass


    def visitBinaryExpressionEnd(self, node):
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
    def visitQuestionnaireBegin(self, questionnaire):
        pass


    def visitQuestionnaireEnd(self, questionnaire):
        pass


    def visitFormStatementBegin(self, node):
        pass


    def visitFormStatementEnd(self, node):
        pass


    def visitIfStatementBegin(self, node):
        pass


    def visitIfStatementEnd(self, node):
        pass


    def visitQuestionStatement(self, node):
        pass