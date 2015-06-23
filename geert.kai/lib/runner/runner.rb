require_relative "../util/base_visitor"
require_relative "../checker/question_visitor"
require_relative "../ast/expression"
require_relative "../ast/form"
require_relative "../ast/types"

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
end
