class AbstractBase:
    @property
    def errors(self):
        raise NotImplementedError


    @property
    def questionnaire(self):
        raise NotImplementedError


    def expressionTypeToken(self, qlType):
        raise NotImplementedError
        

    def operatorToken(self, qlOperator):
        raise NotImplementedError