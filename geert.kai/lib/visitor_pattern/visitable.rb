module QL
  module AST
    module Visitable
      def accept(visitor)
        visitor.visit(self)
      end
    end
  end
end