require_relative 'ql.rb'

class QuestionairApp < JRubyFX::Application
  attr_reader :widgets, :runner
  def start(stage)
    form = QL.parse("spec/ql/source_files/long_query.ql")
    @runner = QL::Runner.new(form)
    @widgets = {}

    this = self
    
    
    with(stage, title: form.name, width: 800, height: 600) do
      layout_scene do
        grid_pane = grid_pane(hgap: 10, vgap: 10, alignment: :baseline_left)  do
          this.runner.questions.each_with_index do |question, position|
            # question.type.widget do
            #   set_id(question.variable_name)
            #   text_property.add_change_listener do |observable, old_value, new_value|
            #     this.runner.update_variable(observable.bean.id, new_value)
            #     puts "#{this.runner.instance_eval { @values }}"
            #     #this.start(stage, this.runner)
            #   end
            # end

            case question.type
            when QL::AST::StringType.new
              widget = text_field do
                set_id(question.variable_name)
                text_property.add_change_listener do |observable, old_value, new_value|
                  this.runner.update_variable(observable.bean.id, new_value)
                  puts "#{this.runner.instance_eval { @values }}"
                  this.reload
                end
              end
            when QL::AST::IntegerType.new
              widget = text_field do
                set_id(question.variable_name)
                text_property.add_change_listener do |observable, old_value, new_value|
                  this.runner.update_variable(observable.bean.id, new_value.to_i)
                  puts "#{this.runner.instance_eval { @values }}"
                  this.reload
                end
              end
            when QL::AST::BooleanType.new
              widget = check_box do
                set_id(question.variable_name)
                set_text("I agree")
                selected_property.add_change_listener do |observable, old_value, new_value|
                  this.runner.update_variable(observable.bean.id, new_value)
                  puts "#{this.runner.instance_eval { @values }}"
                  this.reload
                end
              end
            else
              raise "Error: valt door de mand"
            end 
            label = label(question.description)
            add(label, 1, position)
            add(widget, 2, position)

            this.widgets[question] = widget
          end

          this.reload
        end
      end
      
      
      show
    end
  end

  def reload
    @widgets.each do |question, widget|
      widget.set_visible( runner.visible?(question) )
    end
  end
end

QuestionairApp.launch
