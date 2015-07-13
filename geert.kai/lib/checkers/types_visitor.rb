require_relative "../visitor_pattern/base_visitor"

module QL
  module Checkers
    class TypesVisitor
      def visit(base)
        questions = base.accept(VisitorPattern::QuestionVisitor.new)
        questions.map { |q| [q.variable_name, q.type] }
      end
    end
  end
end
