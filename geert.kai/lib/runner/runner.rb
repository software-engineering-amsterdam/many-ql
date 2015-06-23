require_relative "../util/base_visitor"
require_relative "../checker/question_visitor"
require_relative "../ast/expression"
require_relative "../ast/form"
require_relative "../ast/types"

module QL
  class VisibilityVisitor < BaseVisitor
    def initialize(values)
      @values = values
    end

    def update_variable(variable_name, value)
      @values[variable_name] = value
      
      run(@values)
    end

    def visit_form(form)
      form.statements.flat_map do |statement|
        visit(statement)
      end
    end

    def visit_question(question)
      question
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
        visit(statement)
      end
    end
  end
end

