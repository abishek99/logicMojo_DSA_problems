package com.logicmojo.greedyalgorithm;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NMeetingInOneRoom {

    public int nMeetingInRoom(int[] start, int[] end) {
        PriorityQueue<Meeting> pq = new PriorityQueue<>(Comparator.comparingInt((Meeting m) -> m.end));
        for(int i =0 ;i <start.length; i++) {
            pq.offer(new Meeting(start[i],end[i]));
        }
        int totalMeeting = 0;
        int prevEnd = -1;
        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            if (meeting.start > prevEnd) {
                totalMeeting++;
                prevEnd = meeting.end;
            }
        }
        return totalMeeting;
    }

    public class Meeting {
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
