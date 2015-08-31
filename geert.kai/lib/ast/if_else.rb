module QL
  module AST
    class IfElse
      attr_reader :expression, :statements_true, :statements_false

      def initialize(expression, statements_true, statements_false)
        @expression = expression
        @statements_true = statements_true
        @statements_false = statements_false
      end

      def accept(visitor)
        visitor.visit_if_else(self)
      end

      def statements
        statements_true + statements_false
      end
    end
  end
end
