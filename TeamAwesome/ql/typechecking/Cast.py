from .. import CustomTypes

def castableTo(fromType):
    castingSpec = {
        # int: [CustomTypes.Money],
        # CustomTypes.Money: [int]
    }

    if fromType in castingSpec:
        return castingSpec[fromType]

    return []

def effectiveTypes(actualType):
    return [actualType] + castableTo(actualType)