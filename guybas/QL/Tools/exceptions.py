import pyparsing as pp


class TypeException(Exception):
    def __init__(self, error):
        pass


class ParseException(Exception):
    def __init__(self, error):
        pass


class BuildException(Exception):
    def __init__(self, error):
        pass


class RuntimeException(Exception):
    def __init__(self, error):
        pass


class FactoryException:
    def __init__(self, e):
        print(type(e))

        if type(e) is pp.ParseException:
            raise ParseException(e)
        elif type(e) is RuntimeException:
            raise RuntimeException(e)
        elif type(e) is TypeException:
            raise TypeException(e)
