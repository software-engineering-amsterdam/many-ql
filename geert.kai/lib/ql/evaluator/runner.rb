require_relative "../../util/base_visitor"
require_relative "../../ql/ast/ast"

module QL

  # class StyledRunner < Runner
  #   def 
  # end

  class Runner

    attr_reader :questions, :renderers


    def initialize(ql_ast)
      @ql_ast = ql_ast
      @questions = QuestionVisitor.new(@ql_ast).questions
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

  class QuestionVisitor < BaseVisitor
    def questions
      visit @base
    end

    def visit_form(form)
      map_accept(form.statements).flatten
    end

    def visit_conditional(condition)
      map_accept(condition.statements)
    end

    def visit_question(question)
      question
    end
  end

  class VisibleQuestionVisitor < QuestionVisitor
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

    def render(controller)
      widget = case @question.type
      when AST::BooleanType.new
        input = Java::JavafxSceneControl::CheckBox.new
        input.set_id(@question.variable_name)
        input.selected_property.add_change_listener do |observable, old, new_value|
          controller.update_variable(observable.bean.id, new_value)
        end
        input
      when AST::StringType.new
        input = Java::JavafxSceneControl::TextField.new
        input.set_id(@question.variable_name)
        input.text_property.add_change_listener do |observable, old, new_value|
          controller.update_variable(observable.bean.id, new_value)
        end
        input
      when AST::IntegerType.new
        input = Java::JavafxSceneControl::TextField.new
        input.set_id(@question.variable_name)
        input.text_property.add_change_listener do |observable, old, new_value|
          controller.update_variable(observable.bean.id, new_value.to_i)
        end
        input
      end

      label = Java::JavafxSceneControl::Label.new(@question.description)
      QuestionPane.new(@question, label, widget)



    end
  end
end

