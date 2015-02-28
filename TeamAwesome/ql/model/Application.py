from ..Visitor import Visitor as GenericVisitor


class Application:
    def __init__(self, forms):
        self._forms = forms

    @property
    def forms(self):
        return self._forms


class Visitor(GenericVisitor):
    def _visitApplication(self, application):
        for form in application.forms:
            self.visit(form)
            
    def _visitForm(self, form):
        for question form.questions:
            self.visit(question)

    def _visitComputedBooleanQuestion(self, question):
        pass

    def _visitComputedIntegerQuestion(self, question):
        pass

    def _visitComputedMoneyQuestion(self, question):
        pass

    def _visitComputedStringQuestion(self, question):
        pass

    def _visitInputBooleanQuestion(self, question):
        pass

    def _visitInputIntegerQuestion(self, question):
        pass

    def _visitInputMoneyQuestion(self, question):
        pass

    def _visitInputStringQuestion(self, question):
        pass