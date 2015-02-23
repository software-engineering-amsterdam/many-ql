require_relative "visitor"

class StaticChecker < BaseVisitor
  def initialize(form)
    @form = form
    after_initialize(form)
    self
  end

  def after_initialize(form)
  end

  visitor_for Form do |form|
    form.accept(self)
  end

  private

  attr_reader :form
end
