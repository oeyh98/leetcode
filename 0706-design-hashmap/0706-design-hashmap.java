class MyHashMap {
    public class Node {
        int key, value;
        Node next;
    
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    final Node[] nodes = new Node[1000001];
    
    public void put(int key, int value) {
        int index = key % nodes.length;
        
        if(nodes[index] == null){
            nodes[index] = new Node(key, value);
            return;
        }
        
        Node node = nodes[index];
        
        while (node != null){
            if(node.key == key){
                node.value = value;
                return;
            }
            if(node.next == null)
                break;
            node = node.next;
        }
        
        node.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = key % nodes.length;
        Node node = nodes[index];
        if(node == null)
            return -1;
        
        while(node != null){
            if(node.key == key)
                return node.value;
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % nodes.length;
        Node node = nodes[index];
        
        if(node == null)
            return;
        
        if(node.key == key){
            if(node.next == null)
                nodes[index] = null;
            else
                nodes[index] = node.next;
        }
        Node prev = node;
        while(node != null){
            if(node.key == key){
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */