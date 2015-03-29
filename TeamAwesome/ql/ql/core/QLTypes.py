from decimal import Decimal

class QLType(object):
	def __init__(self, value):
		self._value = value

	@property
	def value(self):
		return self._value

	def __str__(self):
		return str(self.value)

	def __hash__(self):
		return hash(self._value)

	def __eq__(self, other):
		return isinstance(other, self.__class__) and \
			self.value == other.value

	def __ne__(self, other):
		return not self.__eq__(other)


class QLInteger(QLType):
	def __init__(self, value):
		self._value = int(value)


class QLString(QLType):
	def __init__(self, value):
		self._value = str(value)


class QLIdentifier(QLType):
	def __init__(self, value):
		self._value = str(value)


class QLMoney(QLType):
	def __init__(self, value):
		self._value = Decimal(value)


class QLBoolean(QLType):
	def __init__(self, value):
		self._value = bool(value)	
