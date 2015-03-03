rule '.rb' => '.y' do |t|
  sh "racc -l -o #{t.name} #{t.source}"
end

task :compile_ql => 'lib/ql/parser/parser.rb'

task :compile_qls => 'lib/qls/parser/parser.rb'

task :test => [:compile_ql, :compile_qls]

task :test do |t|
  sh "rspec"
end