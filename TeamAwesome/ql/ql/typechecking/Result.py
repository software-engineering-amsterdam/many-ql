from . import Message
from ..Visitor import Visitor as GenericVisitor


# Why the vague name? We're not sure that in the future we want
# the type checker to be able to return more than simply a list
# of messages. Maybe something the evaluator can use.
# It's the Result Object pattern.
class Result:
    def __init__(self, messages = []):
        self._messages = messages

    @property
    def messages(self):
        return self._messages

    @property
    def errors(self):
        visitor = CollectErrorsVisitor()
        visitor.visit(self)
        return visitor.errors

    @property
    def warnings(self):
        visitor = CollectWarningsVisitor()
        visitor.visit(self)
        return visitor.warnings

    def withMessage(self, message):
        return Result(self._messages + [message])

    @staticmethod
    def merge(results):
        result = Result()
        for r in results:
            result = Result(result.messages + r.messages)
        return result


class Visitor(GenericVisitor):
    def _visitResult(self, result):
        for message in result.messages:
            self.visit(message)

    def _visitError(self, error):
        pass

    def _visitWarning(self, error):
        pass


class CollectErrorsVisitor(Visitor):
    def __init__(self):
        self._errors = [] 

    @property
    def errors(self):
        return self._errors

    def _visitError(self, error):
        self._errors.append(error)


class CollectWarningsVisitor(Visitor):
    def __init__(self):
        self._warnings = [] 

    @property
    def warnings(self):
        return self._warnings

    def _visitWarning(self, warning):
        self._warnings.append(warning)
