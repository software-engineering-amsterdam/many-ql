class Array
  def duplicates
    each_with_object({}) do |element, counts|
      counts[element] = counts.fetch(element, 0) + 1
    end.select { |element, count| count > 1}.keys
  end
end
