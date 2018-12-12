package linkedlist;

/*
*   1. 单链表的插入、删除操作
*   2. 链表元素为int型
* */
public class SingleLinkList {
    public class Node{
        private int data;
        private Node next;
        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
        public int getData(){
            return data;
        }
    }

    private Node head = null;
    public Node findByValue(int value){
        Node p = head;
        while(p != null && p.data != value){
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while(p != null && pos != index){
            p = p.next;
            pos++;
        }
        return p;
    }

    //无头结点
    //表头部插入
    public void insertToHead(Node newNode){
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head.next;
            head.next = newNode;
        }
    }
    public void insertToHead(int value){
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }

    //顺序插入
    //链表尾部插入
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        if(head==null){
            head = newNode;
        }else{
            Node q = head;
            while(q.next!=null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    //在某个节点之后插入数据
    public void insertAfter(Node p,Node newNode){
        if(p==null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertAfter(Node p,int value){
        Node newNode = new Node(value,null);
        insertAfter(p,newNode);
    }
}
