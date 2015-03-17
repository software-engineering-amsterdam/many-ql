require_relative "string"

class BaseVisitor
  def initialize(base)
    @base = base
  end

  def self.run(base, *args)
    new(base).run(*args)
  end

  def run()
    raise "not implemented"
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
