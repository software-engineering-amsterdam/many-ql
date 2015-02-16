#class Expression
  #attr_reader :operator, :arguments

  #def initialize(operator:, arguments:)
    #@operator = operator
    #@arguments = arguments
  #end
#end

class BinaryExpression
  attr_reader :lhs, :rhs

  def initialize(lhs, rhs)
    @lhs = lhs
    @rhs = rhs
  end
end

class BooleanExpression < BinaryExpression # || &&
  def type
    :boolean
  end

  def argument_type
    :boolean
  end
end

class EqualityExpression < BinaryExpression # ==, !=
  def type
    :boolean
  end

  def argument_type
    [:boolean, :string, :integer]
  end
end

class OrderingExpression < BinaryExpression # <, >, <=, >=
  def type
    :boolean
  end

  def argument_type
    :integer
  end
end

class IntegerExpression < BinaryExpression # * + - /
  def type
    :integer
  end

  def argument_type
    :integer
  end
end

class Variable
  attr_reader :name

  def initialize(name)
    @name = name
  end
end

class And < BooleanExpression
  def evaluate
    lhs && rhs
  end
end

class Or < BooleanExpression
  def evaluate
    lhs || rhs
  end
end

class Equal < EqualityExpression
  def evaluate
    lhs == rhs
  end
end

class Inequal < EqualityExpression
  def evaluate
    lhs != rhs
  end
end

class LessThan < OrderingExpression
  def evaluate
    lhs < rhs
  end
end

class LessThanOrEqualTo < OrderingExpression
  def evaluate
    lhs <= rhs
  end
end

class GreaterThan < OrderingExpression
  def evaluate
    lhs > rhs
  end
end

class GreaterThanOrEqualTo < OrderingExpression
  def evaluate
    lhs >= rhs
  end
end

class Plus < IntegerExpression
  def evaluate
    lhs + rhs
  end
end

class Minus < IntegerExpression
  def evaluate
    lhs - rhs
  end
end

class Multiplication < IntegerExpression
  def evaluate
    lhs * rhs
  end
end

class Division < IntegerExpression
  def evaluate
    lhs / rhs
  end
end

