def exceptions_handling(e):
    print("Error occured!")
    print(type(e))
    print(e)


class QException(Exception):
    pass