package com.logicmojo.greedyalgorithm;

import java.util.Arrays;

public class JobSequencing {

    public int[] jobSequencing(int[] deadLine,int[] profit) {
        Job[] jobs = new Job[deadLine.length];
        int maxDeadLine = 0;
        for (int i = 0; i < deadLine.length; i++) {
            jobs[i] = (new Job(deadLine[i], profit[i]));
            maxDeadLine = Math.max(maxDeadLine, deadLine[i]);
        }
        Arrays.sort(jobs, ((Job j, Job k) -> k.profit - j.profit));
        int[] slotsAvailable = new int[maxDeadLine + 1];
        Arrays.fill(slotsAvailable, -1);

        int maxProfit = 0;
        int slotsOccupied = 0;

        for (Job job : jobs) {
            int jobDeadLine = job.getDeadLine();
            for (int d = jobDeadLine; d > 0; d--) {
                if (slotsAvailable[d] == -1) {
                    slotsAvailable[d] = job.getProfit();
                    maxProfit += job.getProfit();
                    slotsOccupied++;
                    break;
                }
            }
        }
        return new int[] {slotsOccupied, maxProfit};
    }


    public class Job {

        private int deadLine;
        private int profit ;

        public Job(int deadLine, int profit) {
            this.deadLine = deadLine;
            this.profit = profit;
        }

        public int getDeadLine() {
            return deadLine;
        }
        public int getProfit() {
            return profit;
        }
    }
}
