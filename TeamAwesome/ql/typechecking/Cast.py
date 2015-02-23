import CustomTypes

def castableTo(fromType):
    castables = {
        # int: [CustomTypes.Money],
        # CustomTypes.Money: [int]
    }

    if fromType in castables:
        return castables[fromType]

    return []

def effectiveTypes(actualType):
    return [actualType] + castableTo(actualType)