class QLType(object):
	def __init__(self, value):
		self._value = value

	@property
	def value(self):
		return self._value

	def __str__(self):
		return "%s:%s" %(self.__class__.__name__, self.value)

	def __hash__(self):
		return hash(self._value)

	def __eq__(self, other):
		return isinstance(other, self.__class__) and \
			self.value == other.value

	def __ne__(self, other):
		return not self.__eq__(other)


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
