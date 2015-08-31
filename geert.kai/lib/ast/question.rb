module QL
  module AST
    class Question
      attr_reader :description, :variable_name, :type

      def initialize(description, variable_name, type)
        @description = description
        @variable_name = variable_name
        @type = type
      end

      def accept(visitor)
        visitor.visit_question(self)
      end
    end
  end
end
