module QL
  module AST
    class Node
      def accept(visitor)
        visitor.visit(self)
      end
    end

    class Form < Node 
      attr_reader :name, :statements

      def initialize(name, statements = [])
        @name = name
        @statements = statements
      end
    end

    class Statement < Node
    end

    class Question < Statement
      attr_reader :description, :variable_name, :type

      def initialize(description, variable_name, type)
        @description = description
        @variable_name = variable_name
        @type = type
      end
    end

    class Conditional < Statement
    end

    class If < Conditional
      attr_reader :expression, :statements

      def initialize(expression, statements = [])
        @expression = expression
        @statements = statements
      end

      def statements_true
        statements
      end
      
      def statements_false
        []
      end
    end

    class IfElse < Conditional
      attr_reader :expression, :statements_true, :statements_false

      def initialize(expression, statements_true = [], statements_false = [])
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