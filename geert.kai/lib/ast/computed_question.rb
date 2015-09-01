module QL
  module AST
    class ComputedQuestion
      attr_reader :description, :expression, :type

      def initialize(description, expression, type)
        @description = description
        @expression = expression
        @type = type
      end

      def accept(visitor)
        visitor.visit_question(self)
      end
    end
  end
end
