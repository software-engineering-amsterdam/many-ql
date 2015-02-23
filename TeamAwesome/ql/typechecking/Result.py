from . import Message

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
