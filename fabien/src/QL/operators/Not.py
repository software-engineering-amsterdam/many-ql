
class Not:
    def __init__(self, value):
        self.value = value

    def getType(self, IDs=None):
        return "boolean"

    def checkType(self, IDs):
        try:
            valueType = IDs[self.value]
            boolTypes = ["boolean"]

            return valueType in boolTypes
        except:
            pass

        return False

    def evaluate(self, answers):
        return not self.value

    def __repr__(self):
        return "!%s" % (self.value)
