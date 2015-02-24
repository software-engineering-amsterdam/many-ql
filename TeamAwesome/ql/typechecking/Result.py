from . import Message

# Why the vague name? We're not sure that in the future we want
# the type checker to be able to return more than simply a list
# of messages. Maybe something the evaluator can use.
# It's the Result Object pattern.
class Result:
    def __init__(self, messages = []):
        self.__messages = messages

    @property
    def messages(self):
        return self.__messages

    @property
    def errors(self):
        return [
            m for m in self.messages
            if isinstance(m, Message.Error)
        ]

    def withMessage(self, message):
        return Result(self.__messages + [message])

    @staticmethod
    def merge(results):
        result = Result()
        for r in results:
            result = Result(result.messages + r.messages)
        return result

    @property
    def success(self):
        return (self.errors) == 0
