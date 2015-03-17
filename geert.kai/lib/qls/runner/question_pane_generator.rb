require_relative "../../util/base_visitor"

require_relative "../../ql/checker/question_visitor"
require_relative "../../ql/runner/renderer_visitor"

module QLS
  class QuestionPaneGenerator < BaseVisitor
    attr_reader :classes

    def run(ql, delegate)
      @classes = []
      @delegate = delegate
      
      @questions = QL::Checking::QuestionVisitor.run(ql)
      @question_hash = @questions.map { |question| [question.variable_name,  question] }.to_h

      visit(@base).flatten
    end

    def visit_style_group(section)
      name = "#{section.class.to_s.snake_case}_#{section.object_id}"
      
      @classes.push(name)
      map = map_accept(section.rules)
      @classes.pop

      map
    end

    def visit_question(question)
      render_question_pane(@question_hash[question.name], @delegate, @classes)
    end

    def visit_default(default)
      []
    end

    def render_question_pane(question, delegate, classes = [])
      widget = question.type.widget(delegate)
      widget.set_id(question.variable_name)

      label = Java::JavafxSceneControl::Label.new(question.description)
      label.set_id(question.variable_name)

      (classes << question.type.name).each do |klass|
        widget.get_style_class.add(klass)
        label.get_style_class.add(klass)
      end

      widget.get_style_class.add("widget")
      label.get_style_class.add("label")
      
      QuestionPane.new(question, label, widget)
    end
  end
end