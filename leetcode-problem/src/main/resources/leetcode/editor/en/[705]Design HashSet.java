//Design a HashSet without using any built-in hash table libraries. 
//
// Implement MyHashSet class: 
//
// 
// void add(key) Inserts the value key into the HashSet. 
// bool contains(key) Returns whether the value key exists in the HashSet or not
//. 
// void remove(key) Removes the value key in the HashSet. If key does not exist 
//in the HashSet, do nothing. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove
//", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//Output
//[null, null, null, true, false, null, true, null, false]
//
//Explanation
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // return True
//myHashSet.contains(3); // return False, (not found)
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // return True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // return False, (already removed) 
//
// 
// Constraints: 
//
// 
// 0 <= key <= 106 
// At most 104 calls will be made to add, remove, and contains. 
// 
// Related Topics Array Hash Table Linked List Design Hash Function 
// 👍 1296 👎 159


//leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet {

    class Node{
        int key;
        Node prev;
        Node next;
    }


    Node[] array;
    int length ;
    int threshold;

    int size;
    public MyHashSet() {
        array = new Node[Math.pow(2,10)];
        length = Math.pow(2,10);
        threshold = length*0.75;
        size = 0;
    }
    
    public void add(int key) {
        int index = getIndex(key);
        Node node = findValueByIndex(key,index);
        if(node ==null){
            Node node = new Node();
            node.key = key;
            node.next=array[index];

            if(array[index]!=null){
                array[index].prev=node;
            }
            array[index] = node;

            size++;
            if(size>length*0.75){
                resize();
            }
        }
    }

    public void resize(){

        int newLength = length*2;
        Node[] newArray = new Node[newLength];

        for(int i=0;i<length;i++){
            Node node = array[i];
            while(node!=null){
                Node temp = node;
                node = node.next;
                temp.prev = null;

                int newIndex = getIndex(temp.key,newLength);
                Node newNode = newArray[newIndex];
                addNodeTohead(newNode,temp);
                newArray[newIndex]=temp;
            }
        }

        array = newArray;
        length = newLength;
        threshold = 2*threshold;
    }

    public addNodeToHead(Node list,Node node){
        if(list!=null){
            node.next = list;
            list.prev = node;
        }else{
            list=node;
        }
    }

    public Node findValueByIndex(int key,int index){
        Node node = array[index];
        if(node==null){
            return null;
        }
        while(node.next!=null){
            if(node.key = key){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(int key) {

        Node node = findValueByIndex(key,getIndex(key));
        if(node!=null){
            size--;
            if(node.prev!=null){
                node.prev.next=node.next;
            }
            if(node.next!=null){
                node.next.prev = node.prev;
            }
        }
    }
    
    public boolean contains(int key) {
        Node node = findValueByIndex(key,getIndex(key));
        return node!=null;
    }


    public int getIndex(int key,int length){
        return key%length;
    }

    public int hashCode(int key){
        return key;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
