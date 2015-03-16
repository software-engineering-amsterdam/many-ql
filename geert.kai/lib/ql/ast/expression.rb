require_relative "form"

module QL
  module AST
    class Expression < Node
      def accept(visitor)
        visitor.visit(self)
      end
    end

    class Variable < Expression
      attr_reader :name

      def initialize(name)
        @name = name
      end
    end

    class Literal < Expression
      attr_reader :value

      def initialize(value)
        @value = value
      end

      def to_s
        @value.to_s
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

    # Expressions

    class BinaryExpression < Expression
      attr_reader :lhs, :rhs

      def initialize(lhs, rhs)
        @lhs = lhs
        @rhs = rhs
      end
    end

    class BooleanExpression < BinaryExpression # || &&
      def type
        BooleanType.new
      end

      def possible_argument_types
        [BooleanType.new]
      end
    end

    class EqualityExpression < BinaryExpression # ==, !=
      def type
        BooleanType.new
      end

      def possible_argument_types
        [BooleanType.new, StringType.new, IntegerType.new]
      end
    end

    class OrderingExpression < BinaryExpression # <, >, <=, >=
      def type
        BooleanType.new
      end

      def possible_argument_types
        [IntegerType.new]
      end
    end

    class IntegerExpression < BinaryExpression # * + - /
      def type
        IntegerType.new
      end

      def possible_argument_types
        [IntegerType.new]
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
  end
end