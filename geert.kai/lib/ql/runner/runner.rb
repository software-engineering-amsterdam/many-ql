require_relative "../../util/base_visitor"
require_relative "../checker/question_visitor"
require_relative "../../ql/ast/ast"

module QL
  class Runner
    attr_reader :renderers
    def initialize(ql_base)
      @ql_base = ql_base
      @renderers = RendererVisitor.run(@ql_base)
      @values = {}

      calculate_visible_questions
    end

    def update_variable(variable_name, value)
      @values[variable_name] = value
      
      calculate_visible_questions
    end

    def calculate_visible_questions
      VisibleQuestionVisitor.run(@ql_base, @values)
    end
  end

  class RendererVisitor < Checking::QuestionVisitor
    def visit_question(question)
      QuestionRenderer.new(question)
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

  class VisibleQuestionVisitor < Checking::QuestionVisitor
    def run(values)
      @values = values
      @visible = true
      
      data = visit(@base).join
      File.write('temp/stylesheets/visible_questions.css', data)
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

      (@classes << widget_builder.name).each do |klass|
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
