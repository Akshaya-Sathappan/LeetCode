class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int components = n;

        if(edges.length != n - 1){
            return false;
        }

        for(int[] e : edges){
            if(!dsu.union(e[0], e[1])){
                return false;
            }
            components--;
        }

        return components == 1;
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
        int nu = find(u);
        int nv = find(v);

        if(nu == nv){
            return false;
        }

        if(size[nu] < size[nv]){
            parent[nu] = nv;
            size[nv] += size[nu];
        }
        else{
            parent[nv] = nu;
            size[nu] += size[nv];
        }

        return true;
    }
}