public class DSU {
    private int[] parent;
    private int[] rank;
    private int[] size;

    // Constructor
    public DSU(int n) {
        parent = new int[n];
        rank   = new int[n];
        size   = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // each node points to itself
            rank[i]   = 0;
            size[i]   = 1;
        }
    }

    // ─────────────────────────────────────────
    // 1. FIND — with Path Compression
    // ─────────────────────────────────────────
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // flatten the tree
        }
        return parent[x];
    }

    // ─────────────────────────────────────────
    // 2. UNION (basic) — no heuristic
    // ─────────────────────────────────────────
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false; // already connected
        parent[px] = py;            // attach x's root under y's root
        return true;
    }

    // ─────────────────────────────────────────
    // 3. UNION BY RANK
    // ─────────────────────────────────────────
    // Attach the tree with smaller rank under the taller one.
    // Rank = upper bound of the height of the tree.
    // Only increases rank when both trees have equal rank.
    public boolean unionByRank(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;         // px is shorter, attach under py
        } else if (rank[px] > rank[py]) {
            parent[py] = px;         // py is shorter, attach under px
        } else {
            parent[py] = px;         // equal height, pick either
            rank[px]++;              // height increases by 1
        }
        return true;
    }

    // ─────────────────────────────────────────
    // 4. UNION BY SIZE
    // ─────────────────────────────────────────
    // Attach the smaller set under the larger set.
    // Size = actual number of nodes in the component.
    // Always merge smaller into larger.
    public boolean unionBySize(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;

        if (size[px] < size[py]) {
            parent[px] = py;         // px is smaller, attach under py
            size[py] += size[px];    // update py's size
        } else {
            parent[py] = px;         // py is smaller (or equal), attach under px
            size[px] += size[py];    // update px's size
        }
        return true;
    }
}
```

---

## How Each Works

**`find(x)`** — Recursively walks up to the root, and on the way back *flattens* every node directly to the root. This is path compression.
```
Before:  1 → 2 → 3 → 4 (root)
After:   1 → 4,  2 → 4,  3 → 4   (all point directly to root)