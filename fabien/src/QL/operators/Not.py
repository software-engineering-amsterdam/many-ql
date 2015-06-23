
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
        except Exception as err:
            return True

        return True

    def evaluate(self, answers):
        print self.value
        return not self.value.evaluate(answers)

    def __repr__(self):
        return "!%s" % (self.value)
