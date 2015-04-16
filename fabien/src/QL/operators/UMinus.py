
from numberTypes import numberTypes
from src.QL.nodes.Number import Number

class UMinus:
    def __init__(self, value):
        self.value = Number(None, value)

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
        return -1 * self.value.evaluate(answers)

    def __repr__(self):
        return "-%s" % (self.value)
