class TypeWarning:
    def __init__(self, message, category):
        self.message = message
        self.category = category

    def message(self):
        return self.message

    def category(self):
        return self.category

    def print_message(self):
        print("Warning: (" + self.category + "): " + self.message)