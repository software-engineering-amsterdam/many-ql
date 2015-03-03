require "require_all"
require "stringio"

if RUBY_ENGINE == "jruby"
  require "ruby-debug"
  require "jrubyfx"
else
  require "byebug"
end

require_all "lib/ql"

module QL
  def self.parse(path)
    input     = StringIO.new(File.read(path))
    tokenizer = Tokenizer.new input
    parser    = Parser.new(tokenizer)
    result    = parser.parse
    result
  end
end

# class MyApp < JRubyFX::Application
#   attr_reader :widgets, :runner
#   def start(stage)
#     form = QL.parse("spec/source_files/long_query.ql")
#     @runner = Runner.new(form)
#     @widgets = {}

#     this = self
    
    
#     with(stage, title: form.name, width: 800, height: 600) do
#       layout_scene do
#         grid_pane = grid_pane(hgap: 10, vgap: 10, alignment: :baseline_left)  do
#           this.runner.questions.each_with_index do |question, position|
#             # question.type.widget do
#             #   set_id(question.variable_name)
#             #   text_property.add_change_listener do |observable, old_value, new_value|
#             #     this.runner.update_variable(observable.bean.id, new_value)
#             #     puts "#{this.runner.instance_eval { @values }}"
#             #     #this.start(stage, this.runner)
#             #   end
#             # end

#             case question.type
#             when StringType.new
#               widget = text_field do
#                 set_id(question.variable_name)
#                 text_property.add_change_listener do |observable, old_value, new_value|
#                   this.runner.update_variable(observable.bean.id, new_value)
#                   puts "#{this.runner.instance_eval { @values }}"
#                   this.reload
#                 end
#               end
#             when IntegerType.new
#               widget = text_field do
#                 set_id(question.variable_name)
#                 text_property.add_change_listener do |observable, old_value, new_value|
#                   this.runner.update_variable(observable.bean.id, new_value.to_i)
#                   puts "#{this.runner.instance_eval { @values }}"
#                   this.reload
#                 end
#               end
#             when BooleanType.new
#               widget = check_box do
#                 set_id(question.variable_name)
#                 set_text("I agree")
#                 selected_property.add_change_listener do |observable, old_value, new_value|
#                   this.runner.update_variable(observable.bean.id, new_value)
#                   puts "#{this.runner.instance_eval { @values }}"
#                   this.reload
#                 end
#               end
#             else
#               raise "Error: valt door de mand"
#             end 
#             label = label(question.description)
#             add(label, 1, position)
#             add(widget, 2, position)

#             this.widgets[question] = widget
#           end

#           reload
#         end
#       end
      
      
#       show
#     end
#   end

#   def reload
#     @widgets.each do |question, widget|
#       widget.set_visible( runner.visible?(question) )
#     end
#   end
# end

# MyApp.launch
