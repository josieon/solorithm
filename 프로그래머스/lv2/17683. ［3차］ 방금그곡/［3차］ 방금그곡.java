class Solution {
    public String solution(String m, String[] musicinfos) {
        // 정답 (None)으로 초기화
        String answer = "(None)";
        int maxtime = 0;
        // 멜로디 치환
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");
        // 정답 탐색
        for(String s : musicinfos){
            // 문자열 분리
            String[] arr = s.split(",");
            // 멜로디 치환
            arr[3] = arr[3].replaceAll("C#", "c");
            arr[3] = arr[3].replaceAll("D#", "d");
            arr[3] = arr[3].replaceAll("F#", "f");
            arr[3] = arr[3].replaceAll("G#", "g");
            arr[3] = arr[3].replaceAll("A#", "a");
            String tmp = "";
            // 시간 계산 !음악이 00:00를 넘겨서까지 재싱되는 일은 없다는 규칙!
            String[] start = arr[0].split(":");
            String[] end = arr[1].split(":");
            int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
            int min = Integer.parseInt(end[1]) - Integer.parseInt(start[1]) + hour * 60;
            // 재생시간동안 재생되는 멜로디 작성
            for(int i = 0; i < min; i++)
                tmp += arr[3].charAt(i % arr[3].length());
            // 멜로디 포함 여부 및 정답 여부 판단
            if(tmp.contains(m)){
                if(maxtime < min){
                    maxtime = min;
                    answer = arr[2];
                }
            }
        }
        return answer;
    }
}