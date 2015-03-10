require_relative 'ql.rb'
require_relative 'qls.rb'

class QuestionairApp < JRubyFX::Application
  def start(stage)
    ql = QL.parse("spec/ql/source_files/long_query.ql")
    runner = QL::Runner.new(ql)
    #qls = QLS.parse("spec/qls/source_files/long_query.qls")
    
    questionair_controller = QuestionairController.new(runner)

    with(stage, title: ql.name, width: 800, height: 600) do
      layout_scene do
        grid_pane = grid_pane(hgap: 10, vgap: 10, alignment: :baseline_left)  do
          questionair_controller.question_panes.each_with_index do |question_pane, position|
            add(question_pane.label, 1, position)
            add(question_pane.widget, 2, position)
          end
        end
      end
      show
    end
  end
end


class QuestionairController
  attr_reader :question_panes, :runner

  def initialize(runner)
    @runner = runner

    @question_panes = @runner.renderers.map { |r| r.render(self) }

    reload
  end

  def update_variable(variable_name, value)
    @runner.update_variable(variable_name, value)

    reload
  end

  def reload
    @question_panes.each do |pane|
      pane.set_visible( visible?(pane.question) )
    end
  end

  def visible?(question)
    @runner.visible?(question)
  end
end



class QuestionPane
  attr_accessor :question, :label, :widget

  def initialize(question, label, widget)
    @question = question
    @label = label
    @widget = widget
  end

  def set_visible(visible)
    @label.set_visible(visible)
    @widget.set_visible(visible)
  end
end


QuestionairApp.launch
