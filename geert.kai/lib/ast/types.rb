module QL
  module AST
    class Type
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