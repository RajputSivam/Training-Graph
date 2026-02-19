import java.util.*;

public class rr {

    static int[] parent;
    static int[] size;

    static Map<Integer, HashSet<Integer>> componentMap;
    static Map<Integer, Integer> componentBeauty;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();   // (not used but kept as per your input)

        parent = new int[n + 1];
        size = new int[n + 1];
        componentMap = new HashMap<>();
        componentBeauty = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;

            HashSet<Integer> set = new HashSet<>();
            set.add(i);

            componentMap.put(i, set);
            componentBeauty.put(i, 1);
        }

        long totalBeauty = 0;

        while (q-- > 0) {

            int type = sc.nextInt();
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (type == 1) {

                int parentU = find(u);
                int parentV = find(v);

                if (parentU != parentV) {

                    // union by size
                    if (size[parentU] < size[parentV]) {
                        int temp = parentU;
                        parentU = parentV;
                        parentV = temp;
                    }

                    parent[parentV] = parentU;
                    size[parentU] += size[parentV];

                    HashSet<Integer> big = componentMap.get(parentU);
                    HashSet<Integer> small = componentMap.get(parentV);

                    int beautyBig = componentBeauty.get(parentU);

                    for (int node : small) {

                        boolean left = big.contains(node - 1);
                        boolean right = big.contains(node + 1);

                        if (left && right) beautyBig--;
                        else if (!left && !right) beautyBig++;

                        big.add(node);
                    }

                    componentMap.put(parentU, big);
                    componentBeauty.put(parentU, beautyBig);

                    componentMap.remove(parentV);
                    componentBeauty.remove(parentV);
                }
            }

            else if (type == 2) {

                int parentU = find(u);
                int beautyU = componentBeauty.get(parentU);
                totalBeauty += beautyU;
            }
        }

        System.out.println(totalBeauty);
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
}

// 10
// 4
// 3
// 1 1 4
// 2 1 0
// 1 1 2
// 2 2 0
// O/p
// 4