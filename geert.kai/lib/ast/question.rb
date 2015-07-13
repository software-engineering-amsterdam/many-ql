require_relative "../visitor_pattern/visitable"

module QL
  module AST
    class Question
      include Visitable

      attr_reader :description, :variable_name, :type

      def initialize(description, variable_name, type)
        @description = description
        @variable_name = variable_name
        @type = type
      end
    end
  end
end
