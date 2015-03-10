require_relative "string"

class BaseVisitor
  
  def initialize(base)
    @base = base
    after_initialize(base)
  end

  def after_initialize(base)
  end

  def map_accept(list)
    list.map do |item|
      item.accept(self) 
    end
  end

  def visit(subject)
    subject.class.ancestors.each do |ancestor|  
      method_name = :"visit_#{ancestor.name.snake_case}"  
      next unless respond_to?(method_name)
      return send(method_name, subject)
    end  
                                                         
    raise "Can't handle #{subject.class}"  
  end
end
