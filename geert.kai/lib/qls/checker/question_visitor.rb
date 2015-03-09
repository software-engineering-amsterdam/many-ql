require_relative '../../util/base_visitor'

module QLS
  module Checker
    class QuestionVisitor < BaseVisitor
      
      def check(ql_question_names)
        qls_question_names = question_names

        @errors = (qls_question_names - ql_question_names).map do |question|
          Exception.new "#{question} found in QLS, not found in QL"
        end
        + (ql_question_names - qls_question_names).map do |question|
          Exception.new "#{question} found in QL, not found in QLS"
        end
      end

      def question_names
        (visit @base).flatten
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
