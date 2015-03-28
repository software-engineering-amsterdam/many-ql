class Section:
    def __init__(self, order, title=None, style=None):
        self.__order = order
        self.__style = style
        self.__title = title

    def get_order(self):
        return self.__order

    def get_style(self):
        return self.__style

    def get_title(self):
        return self.__title