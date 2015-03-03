class Type
end

class IntegerType < Type
end

class StringType < Type
end

class BooleanType < Type
end




class Literal
  attr_reader :value

  def initialize(value)
    @value = value
  end
end

class IntegerLiteral < Literal
  def type
    IntegerType.new
  end
end

class StringLiteral < Literal
  def type
    StringType.new
  end
end

class BooleanLiteral < Literal
  def type
    BooleanType.new
  end
end
