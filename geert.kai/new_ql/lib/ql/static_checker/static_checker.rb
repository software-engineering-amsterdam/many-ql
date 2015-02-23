require_relative "visitor"

class StaticChecker < BaseVisitor
  def initialize(base)
    @base = base
    after_initialize(base)
    self
  end

  def after_initialize(base)
  end

  def visit_form(form)
    form.accept(self)
  end
end
