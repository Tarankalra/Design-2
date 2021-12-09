// Time Complexity : O(1)
// Space Complexity : O(buckets*buckets)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

    int buckets;
    boolean [][] bucket;
    public MyHashSet() {
        buckets =1000;
        bucket = new boolean[buckets][];
    }

    public void add(int key) {
        int index1 = hashFunc1(key);
        if(bucket[index1] == null) {
            bucket[index1] = index1==0 ? new boolean [1001] : new boolean [1000];
        }

        int index2 = hashFunc2(key);
        bucket[index1][index2] = true;
    }

    public void remove(int key) {
        int index1 = hashFunc1(key);
        if(bucket[index1] == null) {
            return;
        }
        int index2 = hashFunc2(key);
        bucket[index1][index2] = false;
    }

    public boolean contains(int key) {
        int index1 = hashFunc1(key);
        if(bucket[index1] == null) {
            return false;
        }
        int index2 = hashFunc2(key);
        return bucket[index1][index2];
    }

    private int hashFunc1(int key) {
        return key%buckets;
    }

    private int hashFunc2(int key) {
        return key/buckets;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.remove(1);
        hashSet.contains(1);
    }
}

