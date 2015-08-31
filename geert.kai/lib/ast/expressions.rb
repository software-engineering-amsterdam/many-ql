module QL
  module AST
    class BinaryExpression
      attr_reader :lhs, :rhs

      def initialize(lhs, rhs)
        @lhs = lhs
        @rhs = rhs
      end

      def accept(visitor)
        visitor.visit_binary_expression(self)
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
