import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[][] map = new int[3][3];
        for(int i = 0 ; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // int r = 1, c = 2, k = 6;
        // int[][] map = {{1,2,1}, {2,1,3}, {3,3,3}};
        int answer = 0;
        while(true){
            if(r <= map.length && c <= map[0].length && map[r-1][c-1] == k)
                break;
            if(answer == 100){
                System.out.println(-1);
                return;
            }
            if(map.length >= map[0].length){
                ArrayList<ArrayList<Integer>> before = new ArrayList<>();
                int max = 0;
                for(int i = 0; i < map.length; i++){
                    HashMap<Integer, Integer> hash = new HashMap<>();
                    for(int j : map[i]){
                        if(j == 0)
                            continue;
                        hash.put(j, hash.getOrDefault(j, 0) + 1);
                    }
                    List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hash.entrySet());
                    list.sort(new Comparator<Map.Entry<Integer, Integer>>(){
                        @Override
                        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                            if(e1.getValue() == e2.getValue())
                                return e1.getKey() - e2.getKey();
                            return e1.getValue() - e2.getValue();
                        }
                    });
                    ArrayList<Integer> arr = new ArrayList<>();
                    for(Map.Entry<Integer, Integer> entry : list){
                        arr.add(entry.getKey());
                        arr.add(entry.getValue());
                    }
                    before.add(arr);
                    if(max < arr.size())
                        max = arr.size();
                }
                int[] arr = new int[max];
                int j = 0;
                for(ArrayList<Integer> tmp : before){
                    while(tmp.size() < max)
                        tmp.add(0);
                    int i = 0;
                    for(int num : tmp)
                        arr[i++] = num;
                    map[j++] = arr.clone();
                }
            }
            else{
                ArrayList<ArrayList<Integer>> before = new ArrayList<>();
                int max = 0;
                for(int i = 0; i < map[0].length; i++){
                    HashMap<Integer, Integer> hash = new HashMap<>();
                    for(int j = 0; j < map.length; j++){
                        if(map[j][i] == 0)
                            continue;
                        hash.put(map[j][i], hash.getOrDefault(map[j][i], 0) + 1);
                    }
                    List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hash.entrySet());
                    list.sort(new Comparator<Map.Entry<Integer, Integer>>(){
                        @Override
                        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                            if(e1.getValue() == e2.getValue())
                                return e1.getKey() - e2.getKey();
                            return e1.getValue() - e2.getValue();
                        }
                    });
                    ArrayList<Integer> arr = new ArrayList<>();
                    for(Map.Entry<Integer, Integer> entry : list){
                        arr.add(entry.getKey());
                        arr.add(entry.getValue());
                    }
                    before.add(arr);
                    if(max < arr.size())
                        max = arr.size();
                }
                map = new int[max][before.size()];
                for(int i = 0; i < map[0].length; i++){
                    ArrayList<Integer> tmp = before.get(i);
                    while(tmp.size() < max)
                        tmp.add(0);
                    int j = 0;
                    for(int num : tmp)
                        map[j++][i] = num;
                }
                // System.out.println(Arrays.deepToString(map));
            }
            answer++;
            // System.out.println(Arrays.deepToString(map));
        }
        System.out.println(answer);
    }
}