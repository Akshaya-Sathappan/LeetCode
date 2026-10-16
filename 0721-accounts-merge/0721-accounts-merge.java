class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<>();
        DSU dsu = new DSU(accounts.size());

        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(!map.containsKey(email)){
                    map.put(email, i);
                }
                else{
                    dsu.union(map.get(email), i);
                }
            }
        }

        HashMap<Integer, List<String>> merged = new HashMap<>();

        for(Map.Entry<String, Integer> m : map.entrySet()){
            int value = m.getValue();
            String key = m.getKey();
            int parent = dsu.find(value);
            merged.putIfAbsent(parent, new ArrayList<>());
            merged.get(parent).add(key);
        }

        List<List<String>> result = new ArrayList<>();
        int i = 0;

        for(Map.Entry<Integer, List<String>> m : merged.entrySet()){
            int value = m.getKey();
            List<String> emails = m.getValue();
            Collections.sort(emails);
            String name = accounts.get(value).get(0);
            result.add(new ArrayList<>());
            result.get(i).add(name);
            result.get(i).addAll(emails);
            i++;
        }

        return result;
    }
}

class DSU {
    int[] parent;
    int[] size;

    DSU(int n){
        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node){
        if(parent[node] == node){
            return node;
        }

        parent[node] = find(parent[node]);

        return parent[node];
    }

    public boolean union(int u, int v){
        int rootU = find(u);
        int rootV = find(v);

        if(rootU == rootV) return false;

        if(size[rootU] < size[rootV]){
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        }
        else{
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }

        return true;
    }
}