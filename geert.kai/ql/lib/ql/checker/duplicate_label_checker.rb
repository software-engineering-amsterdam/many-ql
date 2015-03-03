require_relative "base_visitor"

class DuplicateLabelChecker < BaseVisitor

  def after_initialize(base)
    @descriptions = []
  end

  def errors
    @errors = []
    visit @base
    @errors
  end

  def visit_form(form)
    map_accept(form.statements)
  end

  def visit_conditional(conditional)
    map_accept(conditional.statements)
  end

  def visit_question(question) 
    if @descriptions.include?(question.description)
      @errors << Exception.new("Warning: Duplicate Label: #{question.description}")
    else
      @descriptions << question.description
    end
  end
end
