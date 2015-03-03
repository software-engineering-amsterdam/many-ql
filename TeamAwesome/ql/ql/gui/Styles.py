from .Widgets import *
from ..CustomTypes import *

def typeStyleTable():
	return {int : Spinbox, Money : TextInput, str : TextInput, bool : Dropdown}