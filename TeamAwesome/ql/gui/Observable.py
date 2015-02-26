class Observable:
    def __init__(self, value = None):
        self._value = value
        self._observers = []

    def registerObserver(self, observer):
        self._observers.append(observer)

    @property
    def value(self):
        return self._value

    @value.setter
    def value(self, newValue):
        oldValue = self.value
        self._value = newValue

        for o in self._observers:
            o(self, oldValue, newValue)