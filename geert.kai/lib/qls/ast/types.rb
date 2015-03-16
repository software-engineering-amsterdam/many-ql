module QLS
  module AST
    class Type
    end

    class IntegerType < Type
      def name
        "integer"
      end
    end

    class StringType < Type
      def name
        "string"
      end
    end

    class BooleanType < Type
      def name
        "boolean"
      end
    end

    class Literal
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
