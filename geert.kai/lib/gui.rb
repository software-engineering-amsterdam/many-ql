require_relative 'ql.rb'

class QuestionairApp < JRubyFX::Application
  # attr_reader :question_panes, :runner
  def start(stage)
    ql = QL.parse("spec/ql/source_files/long_query.ql")
    
    questionair_controller = QuestionairController.new(ql)

    question_panes = questionair_controller.question_panes
    
    #p question_panes
    # p questionair_controller
    

    
    
    
    with(stage, title: ql.name, width: 800, height: 600) do
      layout_scene do
        grid_pane = grid_pane(hgap: 10, vgap: 10, alignment: :baseline_left)  do
          questionair_controller.question_panes.each_with_index do |question_pane, position|
            add(question_pane.label_field, 1, position)
            add(question_pane.input_field, 2, position)

            # this.widgets[question] = widget
            # question.type.widget do
            #   set_id(question.variable_name)
            #   text_property.add_change_listener do |observable, old_value, new_value|
            #     this.runner.update_variable(observable.bean.id, new_value)
            #     puts "#{this.runner.instance_eval { @values }}"
            #     #this.start(stage, this.runner)
            #   end
            # end

          #   case question.type
          #   when QL::AST::StringType.new
          #     widget = text_field do
          #       set_id(question.variable_name)
          #       text_property.add_change_listener do |observable, old_value, new_value|
          #         this.runner.update_variable(observable.bean.id, new_value)
          #         puts "#{this.runner.instance_eval { @values }}"
          #         this.reload
          #       end
          #     end
          #   when QL::AST::IntegerType.new
          #     widget = text_field do
          #       set_id(question.variable_name)
          #       text_property.add_change_listener do |observable, old_value, new_value|
          #         this.runner.update_variable(observable.bean.id, new_value.to_i)
          #         puts "#{this.runner.instance_eval { @values }}"
          #         this.reload
          #       end
          #     end
          #   when QL::AST::BooleanType.new
          #     widget = check_box do
          #       set_id(question.variable_name)
          #       set_text("I agree")
          #       selected_property.add_change_listener do |observable, old_value, new_value|
          #         this.runner.update_variable(observable.bean.id, new_value)
          #         puts "#{this.runner.instance_eval { @values }}"
          #         this.reload
          #       end
          #     end
          #   else
          #     raise "Error: valt door de mand"
          #   end 
          #   label = label(question.description)
          #   add(label, 1, position)
          #   add(widget, 2, position)

          #   this.widgets[question] = widget
          # end
          end
          
        end
      end
      
      
      show
    end
  end

  # def reload
  #   @widgets.each do |question, widget|
  #     widget.set_visible( runner.visible?(question) )
  #   end
  # end
end



# class StyledQuestionairController < QuestionairController
#   attr_reader :widgets, :runner, :stylesheet

#   def initiailize(ql, qls)
#     super(ql)

#     @stylesheet = QLS::Runner.new(qls)
#   end

#   def visible?(question)
#     @runner.visible?(question) && @stylesheet.visible?(question)
#   end
# end



class QuestionairController
  attr_reader :question_panes, :runner

  def initialize(ql)
    
    @runner = QL::Runner.new(ql)

    @question_panes = @runner.questions.map do |question|
      p question
      QuestionPane.new(question)
    end

    reload

  end

  def update_variable(variable_name, value)
    @runner.update_variable(variable_name, value)

    reload
  end

  def reload
    @question_panes.each do |widget|
      widget.set_visible( visible?(widget.question) )
    end
  end

  def visible?(question)
    @runner.visible?(question)
  end
end

class QuestionPane
  attr_reader :question, :label_field, :input_field #value??

  def initialize(question)
    @question = question
    @label_field = Java::JavafxSceneControl::Label.new(@question.description)
    @input_field = Java::JavafxSceneControl::Label.new("hoi")
  end

  def set_visible(visible)
    @label_field.set_visible(visible)
    @input_field.set_visible(visible)
  end
end


QuestionairApp.launch
