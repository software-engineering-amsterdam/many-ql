
class UMinus:
    def __init__(self, value):
        self.value = value

    def getType(self, IDs=None):
        return "number"

    def checkType(self, IDs):
        try:
            valueType = IDs[self.value]
            numberTypes = ["number", "int", "float", "money"]

            return valueType in numberTypes
        except:
            pass

        return True

    def __repr__(self):
        return "-%s" % (self.value)
