
#TODO: test of het ancestor gedoe daadwerkelijk nodig is

class BaseVisitor
  
  def initialize(base)
    @base = base
    after_initialize(base)
    self
  end

  def after_initialize(base)
  end

  def visit(subject)
    # send(:"visit_#{subject.class.name.snake_case}", subject)
    subject.class.ancestors.each do |ancestor|  
      method_name = :"visit_#{ancestor.name.snake_case}"  
      next unless respond_to?(method_name)
      return send(method_name, subject)
    end  
                                                         
    raise "Can't handle #{subject.class}"  
  end
end

class String # kan nog mooier
  def snake_case
    gsub(/AST::/, '').
    gsub(/([A-Z]+)([A-Z][a-z])/,'\1_\2').
    gsub(/([a-z\d])([A-Z])/,'\1_\2').
    tr("-", "_").
    downcase
  end
end
