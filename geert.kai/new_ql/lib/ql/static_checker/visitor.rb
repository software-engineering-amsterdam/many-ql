# The Visitor class is our base class for all visitors.  It implements the  
# "visit" method which Object#accept will call.   
class BaseVisitor  
  # This method will examine the class and ancestors of +thing+. For each  
  # class in the "ancestors" list, it will check to see if the visitor knows  
  # how to handle that particular class. If it can't find a handler for the  
  # +subject+ it will raise an exception.  
  def visit(subject)
    subject.class.ancestors.each do |ancestor|  
      method_name = :"visit_#{ancestor.name.underscore}"  
      next unless respond_to?(method_name)
      return send(method_name, subject)
    end  
                                                         
    raise "Can't handle #{subject.class}"  
  end
end

class String
  def underscore
    word = self.dup
    word.gsub!(/::/, '/')
    word.gsub!(/([A-Z]+)([A-Z][a-z])/,'\1_\2')
    word.gsub!(/([a-z\d])([A-Z])/,'\1_\2')
    word.tr!("-", "_")
    word.downcase!
    word
  end
end
