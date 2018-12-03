package array;

public class Array<E> {
    private E[] data;
    //指向数组第一个没有元素的位置，相当于数组的末尾
    private int size;

    /*
    * 无参构造函数，capacity默认为10
    *
    * @param capacity
    * */
    public Array() {
        this(10);
    }

    /*
    * 构造函数，传入参数capacity进入Array
    *
    * @param capacity
    * */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /*
    *  获取数组元素个数
    *
    *  @return 数组大小
    * */
    public int getSize(){
        return size;
    }
    /*
    *  获取数组的容量
    *
    *  @return 数组容量
    * */
    public int getCapacity(){
        return data.length;
    }

    /*
    *  判断数组是否为空
    *
    *  @return boolean
    * */
    public boolean isEmpty(){
        return size==0;
    }
    //添加元素
    public void add(int index,E e){
        //先判断数组是不是越界
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add element fail\n");
        }
        if(size == data.length){
            resize(2*data.length);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
    //数组末尾添加元素
    public void addFirst(E e){
        this.add(0,e);
    }
    //数组末尾添加元素
    public void addLast(E e){
        this.add(size,e);
    }
    //获取index处的元素
    E get(int index){
        //边界条件判断
        if(index<0 || index >= size){
            throw new IllegalArgumentException("Get element fail\n");
        }
        return data[index];
    }
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

}
