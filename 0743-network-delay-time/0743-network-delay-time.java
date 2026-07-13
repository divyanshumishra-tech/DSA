class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] t : times) {

            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );

        int[] dist = new int[n + 1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k] = 0;

        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int d = curr[0];
            int u = curr[1];

            if(d > dist[u]) continue;

            for(int[] nei : adj.get(u)) {
                int v = nei[0];
                int w = nei[1];

                if(dist[u] + w < dist[v]) {

                    dist[v] = dist[u] + w;

                    pq.offer(new int[]{dist[v],v});
                }
            }
        }

        int ans = -1;

        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}