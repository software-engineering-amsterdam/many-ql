module QLS
  module AST
    class Selector
      attr_reader :declarations

      def accept(visitor)
        visitor.visit(self)
      end
    end

    class Question < Selector
      attr_reader :name

      def initialize(name, declarations)
        @name = name
        @declarations = declarations
      end
    end

    class Default < Selector
      attr_reader :type

      def initialize(type, declarations)
        @type = type
        @declarations = declarations
      end
    end
  end
end