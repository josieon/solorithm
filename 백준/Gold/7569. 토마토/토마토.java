import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;
import java.util.Stack;

public class Main{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    int[][][] tomato = new int[H][N][M];
    int day = 0;
    for(int h = 0; h < H; h++)
    {
      for(int y = 0; y < N; y++)
      {
        st = new StringTokenizer(br.readLine(), " ");
        for(int x = 0; x < M; x++)
        {
          tomato[h][y][x] = Integer.parseInt(st.nextToken());
        }
      }
    }
    /*for(int k = 0 ;k < H; k++)
    {
      System.out.println(Arrays.deepToString(tomato[k]));
    }
    System.out.println();*/
    Stack<int[]> stk1 = new Stack<>();
    Stack<int[]> stk2 = new Stack<>();
    for(int h = 0; h < H; h++)
      {
        for(int y = 0; y < N; y++)
        {
          for(int x = 0; x < M; x++)
          {
            if(tomato[h][y][x] == 1)
            {
              int[] tmp = {h,y,x};
              stk1.add(tmp);
            }
          }
        }
      }
    while(true)
    {
      /*for(int h = 0; h < H; h++)
      {
        for(int y = 0; y < N; y++)
        {
          for(int x = 0; x < M; x++)
          {
            if(tomato[h][y][x] == 1)
            {
              int[] tmp = {h,y,x};
              queue.add(tmp);
            }
          }
        }
      }*/
      while(stk1.size() != 0)
      {
        int[] tmp = stk1.pop();
        int h = tmp[0];
        int y = tmp[1];
        int x = tmp[2];
        if(h > 0)
          if(tomato[h-1][y][x] == 0)
          {
            tomato[h-1][y][x] = 1;
            int[] a = {h-1, y, x};
            stk2.add(a);
          }
        if(h < H-1)
          if(tomato[h+1][y][x] == 0)
          {
            tomato[h+1][y][x] = 1;
            int[] a = {h+1, y, x};
            stk2.add(a);
          }
        if(y > 0)              
          if(tomato[h][y-1][x] == 0)
          {
            tomato[h][y-1][x] = 1;
            int[] a = {h, y-1, x};
            stk2.add(a);
          }
        if(y < N-1)
          if(tomato[h][y+1][x] == 0)
          {
            tomato[h][y+1][x] = 1;
            int[] a = {h, y+1, x};
            stk2.add(a);
          }
        if(x > 0)
          if(tomato[h][y][x-1] == 0)
          {
            tomato[h][y][x-1] = 1;
            int[] a = {h, y, x-1};
            stk2.add(a);
          }
        if(x < M-1)
          if(tomato[h][y][x+1] == 0)
          {
            tomato[h][y][x+1] = 1;
            int[] a = {h, y, x+1};
            stk2.add(a);
          }
      }
      /*for(int k = 0 ;k < H; k++)
      {
        System.out.println(Arrays.deepToString(tomato[k]));
      }
      System.out.println();*/
      if(stk2.size() == 0)
        break;
      while(stk2.size() != 0)
      {
        int[] a = stk2.pop();
        stk1.add(a);
      }
      day++;
    }
    if(Arrays.deepToString(tomato).contains("0"))
      System.out.println(Integer.toString(-1));
    else
      System.out.println(Integer.toString(day));
  }
}