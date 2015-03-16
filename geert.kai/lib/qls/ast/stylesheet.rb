module QLS
  module AST
    class StyleGroup
      attr_reader :name, :rules

      def initialize(name, rules)
        @name = name
        @rules = rules
      end

      def accept(visitor)
        visitor.visit(self)
      end
    end

    class Stylesheet < StyleGroup
    end

    class Page < StyleGroup
    end

    class Section < StyleGroup
    end
  end
end
