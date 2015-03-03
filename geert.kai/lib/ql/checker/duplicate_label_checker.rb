require_relative "../../util/base_visitor"
require_relative "../../util/array"

module QL
  module Checking
    class DuplicateLabelChecker < BaseVisitor
      def errors
        labels = (visit @base).flatten
        labels.duplicates.map { |label| Exception.new("Duplicate label: #{label}.") }
      end

      def visit_form(form)
        map_accept(form.statements)
      end

      def visit_conditional(conditional)
        map_accept(conditional.statements)
      end

      def visit_question(question) 
        question.description
      end
    end
  end
end
