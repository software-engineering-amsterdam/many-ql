from .Widgets import *
from ..core.QLTypes import *

def typeStyleTable():
	return {QLInteger : Spinbox, QLMoney : TextInput, QLString : TextInput, QLBoolean : Dropdown}