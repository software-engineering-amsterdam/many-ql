def onClass(
    receiver,
    subject,
    methodNamer = lambda className:
        '_dispatchOn' + className[0].upper() + className[1:]
):
    className = subject.__class__.__name__
    method = getattr(receiver, methodNamer(className))
    return method(subject)
