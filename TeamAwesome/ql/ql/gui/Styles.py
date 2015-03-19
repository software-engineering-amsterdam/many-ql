from .Widgets import *
from ..QLTypes import *

def typeStyleTable():
	return {QLInteger : Spinbox, QLMoney : TextInput, QLString : TextInput, QLBoolean : Dropdown}