from .. import QLTypes

def castableTo(fromType):
    castingSpec = {
        QLTypes.QLInteger: [QLTypes.QLMoney],
        QLTypes.QLMoney: [QLTypes.QLInteger]
    }

    if fromType in castingSpec:
        return castingSpec[fromType]

    return []

def effectiveTypes(actualType):
    return [actualType] + castableTo(actualType)