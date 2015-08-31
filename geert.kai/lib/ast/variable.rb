module QL
  module AST
    class Variable
      attr_reader :name

      def accept(visitor)
        visitor.visit_variable(self)
      end

      def initialize(name)
        @name = name
      end
    end
  end
end
