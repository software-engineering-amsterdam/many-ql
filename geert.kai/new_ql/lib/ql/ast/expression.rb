require_relative "form"

class Expression < Node
end

class Variable < Expression
  attr_reader :name

  def initialize(name)
    @name = name
  end
  
  def type
    
  end
end

class Literal < Expression
  attr_reader :value

  def initialize(value)
    @value = value
  end

  def ==(other_value)
    value == other_value
  end
end

class IntegerLiteral < Literal
  def type
    :integer
  end
end

class StringLiteral < Literal
  def type
    :string
  end
end

class BooleanLiteral < Literal
  def type
    :boolean
  end
end

# Expressions

class BinaryExpression < Expression
  attr_reader :lhs, :rhs

  def initialize(lhs, rhs)
    @lhs = lhs
    @rhs = rhs
  end

  def accept(visitor)
    lhs.accept(visitor)
    rhs.accept(visitor)
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
    :&
  end
end

class Or < BooleanExpression
  def operator
    :|
  end
end

class Equal < EqualityExpression
  def operator
    :==
  end
end

class Inequal < EqualityExpression
  def operator
    :!=
  end
end

class LessThan < OrderingExpression
  def operator
    :<
  end
end

class LessThanOrEqualTo < OrderingExpression
  def operator
    :<=
  end
end

class GreaterThan < OrderingExpression
  def operator
    :>
  end
end

class GreaterThanOrEqualTo < OrderingExpression
  def operator
    :>=
  end
end

class Plus < IntegerExpression
  def operator
    :+
  end
end

class Minus < IntegerExpression
  def operator
    :-
  end
end

class Multiplication < IntegerExpression
  def operator
    :*
  end
end

class Division < IntegerExpression
  def operator
    :/
  end
end

