package com.yieldmo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruchir on 11/4/2017.
 */
public class Solution {

    public static List<Segment> mergeSegments(List<Segment> input) {
        if (input == null || input.size() <= 1) return input;

        ArrayList<Segment> result = new ArrayList<>();

        /** sort the segments based on start time*/
        input.sort((o1, o2) -> o1.startTime - o2.startTime);

        Segment pre = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            Segment curr = input.get(i);

            if (curr.startTime - pre.endTime > 5) {
                result.add(pre);
                pre = curr;
            } else {
                Segment merged = new Segment(pre.startTime, Math.max(pre.endTime, curr.endTime));
                pre = merged;
            }
        }
        result.add(pre);
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Segment> input = new ArrayList<>();

        Segment s1 = new Segment(29, 33);
        Segment s2 = new Segment(10, 12);
        Segment s3 = new Segment(18, 20);
        Segment s4 = new Segment(1, 8);
        Segment s5 = new Segment(5, 7);
        Segment s6 = new Segment(24,27);

        /*Segment s1 = new Segment(29, 33);
        Segment s2 = new Segment(1, 5);
        Segment s3 = new Segment(11, 20);
        Segment s4 = new Segment(1, 5);
        Segment s5 = new Segment(5, 5);
        Segment s6 = new Segment(26, 27);*/

        input.add(s1);
        input.add(s2);
        input.add(s3);
        input.add(s4);
        input.add(s5);
        input.add(s6);

        List<Segment> result = mergeSegments(input);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }

    }
}
