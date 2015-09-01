require_relative "../visitor_pattern/base_visitor"
require_relative "../visitor_pattern/question_visitor"
require_relative "../ast/expressions"
require_relative "../ast/form"
require_relative "../ast/if_else"
require_relative "../ast/literals"
require_relative "../ast/question"
require_relative "../ast/types"
require_relative "../ast/variable"

module QL
  class VisibilityVisitor < VisitorPattern::BaseVisitor
    def initialize(values)
      @values = values
    end

    def visit_form(form)
      form.statements.flat_map do |statement|
        visit_statement(statement)
      end
    end

    # def visit_statement(statement)
    #   if statement.class == QL::AST::Question
    #     visit_question(statement)
    #   else
    #     visit_if_else(statement)
    #   end
    # end

    def visit_question(question)
      question
    end

    def visit_computed_question(computed_question)
      computed_question
    end

    def visit_if_else(if_else_statement)
      result = if_else_statement.expression.accept(ExpressionEvaluator.new(@values))

      if result == true
        if_else_statement.statements_true
      elsif result == false
        if_else_statement.statements_false
      else
        []
      end.flat_map do |statement|
        visit_statement(statement)
      end
    end
  end
end
