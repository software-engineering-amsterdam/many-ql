require_relative "../../util/base_visitor"
require_relative "../checker/question_visitor"
require_relative "../../ql/ast/ast"

module QL
  class VisibleQuestionsWriter < Checking::QuestionVisitor
    def run(values = {})
      @values = values
      @visible = true
      
      css = visit(@base).join
      File.write('temp/stylesheets/visible_questions.css', css)
      self
    end

    def update_variable(variable_name, value)
      @values[variable_name] = value
      
      run(@values)
    end

    def visit_conditional(condition)
      result = Evaluator.run(condition.expression, @values)

      if result.nil?
        @visible = false
        statements = map_accept(condition.statements)
        @visible = true
        statements
      else
        @visible = result
        true_statements = map_accept(condition.statements_true)
        @visible = !result
        false_statements = map_accept(condition.statements_false)
        @visible = true
        true_statements + false_statements
      end
    end

    def visit_question(question)
      "##{question.variable_name} {#{visibilty_tag}}\n\n"
    end

    def visibilty_tag
      "\n\t -fx-background-color: #CCFF99;" if @visible
    end
  end

  class Evaluator < BaseVisitor
    def run(values)
      @values = values
      visit @base
    end

    def visit_binary_expression(expression) #nil or undefined?
      lhs = expression.lhs.accept(self)
      rhs = expression.rhs.accept(self)

      if lhs.nil? || rhs.nil?
        nil
      else
        lhs.send(expression.operator, rhs)
      end
    end

    def visit_variable(variable)
      @values[variable.name]
    end

    def visit_literal(literal)
      literal.value
    end
  end
end
