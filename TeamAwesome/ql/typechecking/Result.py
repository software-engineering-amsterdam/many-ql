from . import Message

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

    def withMessage(self, message):
        return Result(self._messages + [message])

    @staticmethod
    def merge(results):
        result = Result()
        for r in results:
            result = Result(result.messages + r.messages)
        return result