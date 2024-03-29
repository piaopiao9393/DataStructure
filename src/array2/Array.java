package array2;

public class Array {

    private int[] data;
    private int size;

    //构造函数：传入数组容量capacity构造素组
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //向index索引的位置添加一个元素
    public void add(int index,int e){
        if(size==data.length)
            throw new IllegalArgumentException("Add failled,Array is full");

        if(index<0 || index>size)
            throw new IllegalArgumentException("Add failled,Require index>= 0 and index <= size");

        for(int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
    }

    public void addFirst(int e){
        add(0,e);
    }

    public void addLast(int e){
        add(size,e);
    }

    //获取index位置的元素
    public int get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    //修改index索引位置的元素为e
    public void set(int index,int e){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Set failed.Index is illegal");
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean cotains(int e){
        for(int i=0;i<size;i++){
            if(data[i]==e) return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在e，则返回-1
    public int find(int e){
        for(int i=0;i<size;i++){
            if(data[i]==e) return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public int remove(int index){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Remove is failed.Index is illegal");
        int ret = data[index];
        for(int i=index;i<size-1;i++){
            data[i] = data[i+1];
        }
        return ret;
    }

    public int removeFirst(){
        return remove(0);
    }

    public int removeLast(){
        return remove(size-1);
    }

    //从数组中删除元素e
    public void removeElement(int e){
        int index = find(e);
        if(index !=-1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for(int i=0;i>size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
