class Solution {
    class Node {
        int arr, dept, frnd;

        Node(int arr, int dept, int frnd) {
            this.arr = arr;
            this.dept = dept;
            this.frnd = frnd;
        }
    }

    public int smallestChair(int[][] t, int target) {
        // vector of Node's
        List<Node> v = new ArrayList<>();

        // populate the list
        for (int i = 0; i < t.length; i++) {
            v.add(new Node(t[i][0], t[i][1], i));
        }

        // sorting based on arrival time
        Collections.sort(v, (a, b) -> Integer.compare(a.arr, b.arr));

        // store {leaving time, seat number}
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // store the free seats
        PriorityQueue<Integer> freeSeats = new PriorityQueue<>();

        // starting seat number
        int curChair = 0;

        for (Node node : v) {
            // release the seats where friends have already left
            while (!busy.isEmpty() && busy.peek()[0] <= node.arr) {
                freeSeats.offer(busy.poll()[1]);
            }

            int chair;
            if (!freeSeats.isEmpty()) {
                chair = freeSeats.poll();
            } else {
                chair = curChair++;
            }

            // update the queue with the busy chair
            busy.offer(new int[]{node.dept, chair});

            // when we got the target friend
            if (node.frnd == target) {
                return chair;
            }
        }

        return -1;
    }
}