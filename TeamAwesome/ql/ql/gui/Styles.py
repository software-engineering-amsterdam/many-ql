from .Widgets import *

def typeStyleTable():
	return {int : Spinbox, Money : TextInput, str : TextInput, bool : Dropdown}