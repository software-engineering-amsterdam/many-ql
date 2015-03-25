class Section:
    def __init__(self, order, style=None):
        self.__order = order
        self.__style = style

    def get_order(self):
        return self.__order

    def get_style(self):
        return self.__style