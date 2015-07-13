require_relative "../visitor_pattern/visitable"

module QL
  module AST
    class IfElse
      include Visitable

      attr_reader :expression, :statements_true, :statements_false

      def initialize(expression, statements_true, statements_false)
        @expression = expression
        @statements_true = statements_true
        @statements_false = statements_false
      end

      def statements
        statements_true + statements_false
      end
    end
  end
end
