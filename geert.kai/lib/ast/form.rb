require_relative "visitable"

module QL
  module AST
    class Form
      include Visitable

      attr_reader :name, :statements

      def initialize(name, statements)
        @name = name
        @statements = statements
      end
    end

    class Statement
      include Visitable
    end

    class Question < Statement
      attr_reader :description, :variable_name, :type

      def initialize(description, variable_name, type)
        @description = description
        @variable_name = variable_name
        @type = type
      end
    end

    class IfElse < Statement
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