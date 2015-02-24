require "require_all"
require "jrubyfx"

require_all "lib/"

module QL
  def self.parse(path)
    input     = StringIO.new(File.read(path))
    tokenizer = QL::Tokenizer.new input
    parser    = QL::Parser.new(tokenizer)
    result    = parser.parse
    result
  end
end

class MyApp < JRubyFX::Application
  def start(stage)
    with(stage, title: "Hello app", width: 800, height: 600) do
      layout_scene do
        grid_pane(hgap: 10, vgap: 10, alignment: :baseline_left)  do
          label = label("Wat is uw naam?")
          notification = label("")
          text  = text_field do
            set_id "Pietje"
            text_property.add_listener do |observable, old_value, new_value|
              puts "text field changed: #{observable} #{old_value} #{new_value}"
              notification.text = "text field with id #{observable.bean.id} changed: #{new_value}"
            end
          end
          add(label, 1, 1)
          add(text, 2, 1)
          add(notification, 1, 2)
        end
      end

      show
    end
  end
end

form = QL.parse("spec/source_files/one_query.ql")
@runner = Runner.new(form)

MyApp.launch
