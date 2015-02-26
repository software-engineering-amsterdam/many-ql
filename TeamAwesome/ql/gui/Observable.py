class Observable:
    def __init__(self, value = None):
        self._value = value
        self._observers = []

    def registerObserver(self, callback):
        self._observers.append(callback)

    @property
    def value(self):
        return self._value

    @value.setter
    def value(self, newValue):
        oldValue = self.value
        self._value = newValue

        if oldValue != newValue:
            for observer in self._observers:
                observer(self, oldValue, newValue)