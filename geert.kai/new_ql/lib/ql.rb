require "require_all"
require "jrubyfx"
require "stringio"
require "ruby-debug"

require_all "lib"

module QL
  def self.parse(path)
    input     = StringIO.new(File.read(path))
    tokenizer = Tokenizer.new input
    parser    = Parser.new(tokenizer)
    result    = parser.parse
    result
  end
end

class MyApp < JRubyFX::Application
  def start(stage)
    form = QL.parse("spec/source_files/long_query.ql")
    runner = Runner.new(form)

    this = self
    
    with(stage, title: form.name, width: 800, height: 600) do
      layout_scene do
        grid_pane = grid_pane(hgap: 10, vgap: 10, alignment: :baseline_left)  do
          runner.applicable_questions.each_with_index do |question, position|
            case question.type
            when :string
              widget = text_field do
                set_id(question.variable_name)
                text_property.add_change_listener do |observable, old_value, new_value|
                  runner.update_variable(observable.bean.id, new_value)
                  puts "#{runner.instance_eval { @values }}"
                  #this.start(stage, runner)
                end
              end
            when :integer
              widget = text_field do
                set_id(question.variable_name)
                text_property.add_change_listener do |observable, old_value, new_value|
                  # this.start(stage, runner)
                end
              end
            when :boolean
              widget = check_box do
                set_id(question.variable_name)
                set_text("I agree")
                selected_property.add_change_listener do |observable, old_value, new_value|
                  runner.update_variable(observable.bean.id, new_value)
                  puts "#{runner.instance_eval { @values }}"
                  # this.start(stage, runner)
                end
              end
           
           end 
            label = label(question.description)
            add(label, 1, position)
            add(widget, 2, position)
          end
        end
      end

      show
    end
  end

  def reload
    @grid_pane
  end
end

class Java::javafx::scene::layout::GridPane
end


MyApp.launch
