require_relative 'ql.rb'
require_relative 'qls.rb'

class QuestionairApp < JRubyFX::Application
  def start(stage)
    ql = QL.parse("spec/ql/source_files/long_query.ql")
    qls = QLS.parse("spec/qls/source_files/long_query.qls")
    
    runner = QLS::Runner.new(ql, qls)

    questionair_controller = QuestionairController.new(runner)

    with(stage, title: ql.name, width: 800, height: 600) do
      questionair_controller.scene = layout_scene do
        grid_pane(hgap: 10, vgap: 10, alignment: :baseline_left)  do
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
  attr_reader :question_panes, :runner, :scene

  def initialize(runner)
    @runner = runner

    @question_panes = @runner.renderers.map { |r| r.render(self) }    
  end

  def update_variable(variable_name, value)
    @runner.update_variable(variable_name, value)
    reload
  end

  def scene=(scene)
    @scene = scene
    reload
  end

  def reload
    @scene.get_stylesheets.clear;
    @scene.get_stylesheets.add("temp/stylesheets/visible_questions.css")
    @scene.get_stylesheets.add("temp/stylesheets/style.css")
    @scene.get_stylesheets.add("temp/stylesheets/page.css")
  end
end

class QuestionPane #QuestionPane kunnen we uit het programma schrijven alles gaat via css
  attr_accessor :label, :widget

  def initialize(question, label, widget)
    @label = label
    @widget = widget
  end
end


QuestionairApp.launch
