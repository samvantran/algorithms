package Week1;

/**
 * Created by svt on 4/18/15.
 *
 * Quick-Find (eager) algorithm in the Union-Find family
 * Returns connected==true if and only if p and q have the same id
 *
 * Find is O(1)
 * Union is O(N)
 *
 */
public class QuickFindUF {

  private int[] id;

  public QuickFindUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++)
      id[i] = i;
  }

  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];

    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid)
        id[i] = qid;
    }
  }

  @Override
  public String toString() {
    String array = "";
    for (int i = 0; i < id.length; i++)
      array += id[i] + " ";

    return array;
  }

  public static void main(String[] args) {
    QuickFindUF qf = new QuickFindUF(10);
    qf.union(1, 4);
    qf.union(3, 7);
    qf.union(0, 3);
    qf.union(7, 9);
    qf.union(9, 8);
    qf.union(5, 8);

    System.out.println(qf.toString());
  }
}