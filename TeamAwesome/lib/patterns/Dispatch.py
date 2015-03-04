def onClass(
    receiver,
    subject,
    methodNameResolver = lambda className:
        '_dispatchOn' + className[0].upper() + className[1:]
):
    className = subject.__class__.__name__
    method = getattr(receiver, methodNameResolver(className))
    return method(subject)
