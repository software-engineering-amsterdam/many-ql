require_relative '../ql.rb'
require_relative "questionair_controller"
require_relative "question_pane"
require_relative "widget_visitor"

require "ruby-debug"
require "jrubyfx"


module QL
  module GUI
    class QuestionairApp < JRubyFX::Application
      def start(stage)
        ql = QL.parse("spec/source_files/long_query.ql")

        check_result = QL.check(ql)

        unless check_result[:errors].empty?
          puts check_result[:errors]
          return 1
        end

        # from here we assume ql and qls are valid?
        questionair_controller = QuestionairController.new(ql)

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
  end
end

QL::GUI::QuestionairApp.launch
