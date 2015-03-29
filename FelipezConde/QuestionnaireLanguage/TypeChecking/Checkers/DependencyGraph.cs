using AST.Nodes.Expressions;
using System.Collections.Generic;
using System.Linq;

namespace TypeChecking.Checkers
{
    public class DependencyGraph
    {
        private Dictionary<Id, IEnumerable<Id>> dependencies = new Dictionary<Id, IEnumerable<Id>>();

        public void AddNewDirectDepencencies(Id source, IEnumerable<Id> dependencies)
        {
            this.dependencies[source] =  dependencies;
        }

        public void Combine(DependencyGraph dependencyGraph)
        {
            foreach (KeyValuePair<Id, IEnumerable<Id>> dependency in dependencyGraph.dependencies)
            {
                this.dependencies[dependency.Key] = dependency.Value;
            }
        }

        public IEnumerable<Id> GetCycles()
        {
            FindCycles();
            
            foreach (Id key in dependencies.Keys.Where(key => dependencies[key].Contains(key)))
            {
                yield return key;
            }
        }

        private void FindCycles()
        {
            for (int i = 0; i < dependencies.Count; i++)
            {
                Expand();
            }
        }

        private void Expand()
        {
            foreach (Id source in dependencies.Keys)
            {
                foreach (Id childDependency in dependencies[source])
                {
                    //add dependencies of the childs to the parent
                    dependencies[source].Concat(dependencies[childDependency]);
                }
            }
        }
    }
}
