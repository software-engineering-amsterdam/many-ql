require_relative "../../util/base_visitor"
require_relative "../checker/question_visitor"
require_relative "../../ql/ast/ast"

module QL
  class Runner
    attr_reader :questions, :renderers

    def initialize(ql_ast)
      @ql_ast = ql_ast
      @questions = Checking::QuestionVisitor.new(@ql_ast).questions

      @renderers = @questions.map do |question|
        QuestionRenderer.new(question)
      end
      
      @values = {}
      calculate_visible_questions
    end

    def update_variable(variable_name, value)
      @values[variable_name] = value
      
      calculate_visible_questions
    end

    def calculate_visible_questions
      @visible_questions = VisibleQuestionVisitor.new(@ql_ast).questions(@values)
    end

    def visible?(question)
      @visible_questions.include?(question)
    end
  end

  class Evaluator < BaseVisitor
    def evaluate(values)
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

  class VisibleQuestionVisitor < Checking::QuestionVisitor
    def questions(values)
      @values = values
      
      visit @base
    end

    def visit_conditional(condition)
      case Evaluator.new(condition.expression).evaluate(@values)
      when true
        map_accept(condition.statements_true)
      when false
        map_accept(condition.statements_false)
      when :undefined
        []
      end
    end
  end

  class QuestionRenderer
    def initialize(question, declarations = [])
      @question = question
      @declarations = declarations
    end

    def widget(controller)
      @declarations.each do |declaration|
        return declaration.widget(controller) if declaration.kind_of?(Widget)
      end

      return @question.type.widget(controller)
    end

    def render(controller)
      widget = widget(controller)
      widget.set_id(@question.variable_name)

      label = Java::JavafxSceneControl::Label.new(@question.description)

      QuestionPane.new(@question, label, widget)
    end
  end
end
