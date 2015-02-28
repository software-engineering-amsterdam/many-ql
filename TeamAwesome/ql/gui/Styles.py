from .Widgets import *
from ..CustomTypes import *

def typeStyleTable():
	return {int : NumberSpinbox, Money : TextInputWidget, str : TextInputWidget, bool : TextInputWidget}