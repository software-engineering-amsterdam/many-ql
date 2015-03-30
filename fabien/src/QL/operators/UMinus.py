
from numberTypes import numberTypes

class UMinus:
    def __init__(self, value):
        self.value = value

    def getType(self, IDs=None):
        return "number"

    def checkType(self, IDs):
        try:
            valueType = IDs[self.value]

            return valueType in numberTypes()
        except:
            pass

        return True

    def evaluate(self, answers):
        return -1 * int(self.value)

    def __repr__(self):
        return "-%s" % (self.value)
