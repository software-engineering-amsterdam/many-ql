
class DuplicateLabelChecker < BaseVisitor
  visitor_for Form do |form|
    form.accept(self)
  end

  visitor_for Conditional do |conditional|
    conditional.accept(self)
  end

  visitor_for Question do |question|
    question.description
  end

  def initialize(form)
    @form = form
  end
  
  def check
    descriptions = visit(@form)  
  end
end
