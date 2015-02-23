# The Visitor class is our base class for all visitors.  It implements the  
# "visit" method which Object#accept will call.   
class BaseVisitor  
  # Dynamically create a visitor method for each class in +klasses+  
  def self.visitor_for(*klasses, &block)
    klasses.each do |klass|  
      define_method(:"visit_#{klass.name}", block)  
    end
  end  
  # This method will examine the class and ancestors of +thing+. For each  
  # class in the "ancestors" list, it will check to see if the visitor knows  
  # how to handle that particular class. If it can't find a handler for the  
  # +subject+ it will raise an exception.  
  def visit(subject)
    subject.class.ancestors.each do |ancestor|  
      method_name = :"visit_#{ancestor.name}"  
      next unless respond_to?(method_name)
      return send(method_name, subject)
    end  
                                                         
    raise "Can't handle #{subject.class}"  
  end
end
