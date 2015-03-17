class QLType(object):
	def __init__(self, value):
		self._value = value

	@property
	def value(self):
		return self._value

class QLInteger(QLType):
	pass

class QLString(QLType):
	pass

class QLIdentifier(QLType):
	pass

class QLMoney(QLType):
	pass

class QLBoolean(QLType):
	pass