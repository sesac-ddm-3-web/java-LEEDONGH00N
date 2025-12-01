package collection;

import java.util.HashMap;
import java.util.Map;

public class MarathonRunner {

    public void solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        for (String p : participant) {
            if (map.containsKey(p) && map.get(p) != 0){
                System.out.println("Did not finish: " + p); // 예상 출력: "mislav"
                map.put(p, map.get(p) - 1);
            }
        }
    }

    public static void main(String[] args) {
        MarathonRunner solver = new MarathonRunner();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        solver.solution(participant, completion);
    }
}