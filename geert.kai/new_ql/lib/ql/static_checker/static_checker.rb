require_relative "visitor"

class StaticChecker < BaseVisitor
  def initialize(base)
    @base = base
    after_initialize(base)
    self
  end

  def after_initialize(base)
  end

  def visit_form(base)
    base.accept(self)
  end

  private

  attr_reader :base
end
