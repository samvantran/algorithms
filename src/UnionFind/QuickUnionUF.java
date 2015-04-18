package UnionFind;

/**
 * Created by svt on 4/18/15.
 *
 * Quick-Union (lazy) algorithm in Union-Find family
 * Returns connected==true if p and q have the same root
 *
 * Find is O(N)
 * Union is O(N)
 *
 */
public class QuickUnionUF {

  private int[] id;

  public QuickUnionUF(int N) {
    id = new int[N];
    for( int i = 0; i < N; i++ )
      id[i] = i;
  }

  private int root(int i) {
    while( i != id[i] ) {
      i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);

    id[i] = j;
  }
}
