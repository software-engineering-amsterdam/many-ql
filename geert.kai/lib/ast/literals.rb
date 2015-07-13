require_relative "../visitor_pattern/visitable"

module QL
  module AST
    class Literal
      include Visitable

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
  end
end
