module QL
  class QuestionPaneVisitor
    def intialize(ql, delegate)
      @delegate = delegate
      questions = Checkers::QuestionVisitor.run(ql).map do |question|
        render_question_pane(question, @delegate)
      end
    end

    def visit_form(question)
      render_question_pane(question, @delegate)
    end

    def render_question_pane(question, delegate, classes = [])
      widget = question.type.widget(delegate)
      widget.set_id(question.variable_name)

      label = Java::JavafxSceneControl::Label.new(question.description)
      label.set_id(question.variable_name)

      (classes << widget_builder.name).each do |klass|
        widget.get_style_class.add(klass)
        label.get_style_class.add(klass)
      end

      widget.get_style_class.add("widget")
      label.get_style_class.add("label")
 
      QuestionPane.new(question, label, widget)
    end
  end
end