module QL
  module AST
    class Form
      attr_reader :name, :statements

      def initialize(name, statements)
        @name = name
        @statements = statements
      end

      def accept(visitor)
        visitor.visit_form(self)
      end
    end
  end
end
