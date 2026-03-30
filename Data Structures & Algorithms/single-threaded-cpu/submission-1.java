class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] newTasks = new int[n][3];
        for(int i=0; i<n; i++) {
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }
        Arrays.sort(newTasks, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> taskPopper = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });
        int time = newTasks[0][0];
        for(int[] task : newTasks) {
            if(task[0] <= time) taskPopper.offer(task);
        }
        int[] res = new int[n];
        int ri=0;
        int ti=taskPopper.size();
        while(!taskPopper.isEmpty() && ri < n) {
            int[] task = taskPopper.poll();
            int taskEnqueue = task[0];
            int taskTime = task[1];
            int taskNumber = task[2];
            res[ri++] = taskNumber;
            time += taskTime;
            if(taskPopper.isEmpty() && ti < n && time < newTasks[ti][0])
                time = newTasks[ti][0];
            while(ti < n && newTasks[ti][0] <= time) {
                taskPopper.offer(newTasks[ti]);
                ti++;
            }
        }
        return res;
    }
}