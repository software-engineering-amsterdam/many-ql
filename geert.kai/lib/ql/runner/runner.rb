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
      File.write('temp/stylesheets/visible_questions.css', @visible_questions)
    end

    def visible?(question)
      true#@visible_questions.include?(question)
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
      @visible = true
      
      super().join
    end

    def visit_conditional(condition)
      result = Evaluator.new(condition.expression).evaluate(@values)

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

  class QuestionRenderer
    attr_reader :question, :declarations
    attr_accessor :classes

    def initialize(question, declarations = [])
      @question = question
      @declarations = declarations
    end

    def widget_builder
      @declarations.each do |declaration|
        return declaration if declaration.kind_of?(QLS::AST::Widget)
      end

      return @question.type
    end

    def render(controller)
      widget = widget_builder.widget(controller)
      widget.set_id(@question.variable_name)


      label = Java::JavafxSceneControl::Label.new(@question.description)
      label.set_id(@question.variable_name)

      (@classes << widget_builder.class_name).each do |klass|
        widget.get_style_class.add(klass)
        label.get_style_class.add(klass)
      end
      widget.get_style_class.add("widget")
      label.get_style_class.add("label")

     # widget.get_style_class(widget.name)
      
      QuestionPane.new(@question, label, widget)
    end
  end
end
