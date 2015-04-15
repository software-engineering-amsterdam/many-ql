import Tkinter as tk
import re

from String import String

class Email(String):
    def _onChange(self, ID=None, callback=None, mode=None):
        self.onChange(None)

        # Simple email validation
        if not re.match(r"[^@]+@[^@]+\.[^@]+", self.value()):
            self.setInvalid()