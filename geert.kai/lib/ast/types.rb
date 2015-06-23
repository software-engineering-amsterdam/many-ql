require_relative "../visitor_pattern/visitable"

module QL
  module AST
    class Type
      include Visitable

      def ==(other_type)
        self.class == other_type.class
      end
    end

    class IntegerType < Type
    end

    class StringType < Type
    end

    class BooleanType < Type
    end

    class UndefinedType < Type
    end
  end
end