class Type:
    def __init__(self):
        pass

    def __eq__(self, other):
        return self._name == other.get_name()

    def get_name(self):
        return self._name