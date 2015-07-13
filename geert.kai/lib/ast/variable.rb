require_relative "../visitor_pattern/visitable"

module QL
  module AST
    class Variable
      include Visitable

      attr_reader :name

      def initialize(name)
        @name = name
      end
    end
  end
end
