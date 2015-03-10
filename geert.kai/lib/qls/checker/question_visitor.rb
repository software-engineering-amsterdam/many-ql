require_relative '../../util/base_visitor'

module QLS
  module Checker
    class QuestionVisitor < BaseVisitor
      def questions
        visit(@base).flatten
      end

      def visit_style_group(style_group)
        style_group.rules.map do |rule|
          rule.accept(self)
        end
      end

      def visit_question(question)
        question
      end

      def visit_default(default)
        []
      end
    end
  end
end
