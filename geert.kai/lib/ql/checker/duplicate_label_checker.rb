require_relative "base_visitor"

module QL
  module Checking
    class DuplicateLabelChecker < BaseVisitor

      def after_initialize(base)
        @descriptions = []
      end

      def warnings
        (visit @base).flatten
      end

      def visit_form(form)
        map_accept(form.statements)
      end

      def visit_conditional(conditional)
        map_accept(conditional.statements)
      end

      def visit_question(question) 
        if @descriptions.include?(question.description)
          Exception.new("Warning: Duplicate Label: #{question.description}")
        else
          @descriptions << question.description
          []
        end
      end
    end
  end
end
