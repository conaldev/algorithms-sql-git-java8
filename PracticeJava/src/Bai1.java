import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class Bai1 {
    public static void main(String[] args) {
        String str = "Hello Javaaaaa";
        HashSet<Character> hashSet2 = new HashSet<>();
        HashSet<Character> hashSet = new HashSet<Character>();
        for (int i=0;i<str.length();i++){
            if(!hashSet.add(str.charAt(i)) && hashSet2.add(str.charAt(i))) {
                System.out.println(str.charAt(i));
            }
        }
        Queue<Character> queue = new PriorityQueue<>();
//        for(Character c: hashSet) {
//            queue.offer(c);
//        }
      queue.addAll(hashSet);
      while (true){
          Character c = queue.poll();
          if(c==null)
              break;
          System.out.println(c);
      }
    }
}
