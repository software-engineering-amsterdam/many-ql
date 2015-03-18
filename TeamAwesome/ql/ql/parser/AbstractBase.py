class AbstractBase:
    @property
    def questionnaire(self):
        raise NotImplementedError

    def expressionTypeToken(self, qlType):
        raise NotImplementedError

    def operatorToken(self, qlOperator):
        raise NotImplementedError