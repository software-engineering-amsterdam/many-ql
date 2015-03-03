require_relative '../../util/base_visitor'
require_relative '../../util/array'

module QLS
  module Checker
    class DuplicateQuestionChecker < BaseVisitor
      def errors
        names = visit(@base).flatten
        names.duplicates.map { |name| Exception.new("Question #{name} is defined more than once.") }
      end
      
      def visit_style_group(style_group)
        style_group.rules.map do |rule|
          rule.accept(self)
        end
      end

      def visit_question(question)
        question.name
      end

      def visit_default(default)
        []
      end
    end
  end
end
