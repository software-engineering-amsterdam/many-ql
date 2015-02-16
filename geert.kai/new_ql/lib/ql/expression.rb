#class Expression
  #attr_reader :operator, :arguments

  #def initialize(operator:, arguments:)
    #@operator = operator
    #@arguments = arguments
  #end
#
#end

# ExpressionVariable
require_relative "visitor"

class Variable
  include Visitable
  attr_reader :name

  def initialize(name)
    @name = name
  end
end

# Constants

class Integer
  include Visitable
end

class String
  include Visitable
end

class True
  include Visitable
end

class False
  include Visitable
end


# Expressions

class BinaryExpression
  attr_reader :lhs, :rhs

  def initialize(lhs, rhs)
    @lhs = lhs
    @rhs = rhs
  end

  def accept visitor
    lhs.accept visitor
    rhs.accept visitor
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

class And < BooleanExpression
  def operator
    :and
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

