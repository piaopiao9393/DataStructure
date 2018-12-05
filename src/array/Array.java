package array;

import java.util.Arrays;

public class Array<E> {
    private E[] data;
    //指向数组第一个没有元素的位置，相当于数组的末尾
    private int size;
    //数组的容量
    private int capacity;
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
        this.capacity = capacity;
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
    public E get(int index){
        //边界条件判断
        if(index<0 || index >= size){
            throw new IllegalArgumentException("Get element fail\n");
        }
        return data[index];
    }
    /*
    * 更新指定位置的元素
    *
    * @param index 要更新的位置
    * @param element 更新的元素
    * */
    public void set(int index,E element){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("index的范围需要在[0,index)");
        }
        data[index] = element;
    }
    /*
    * 是否包含指定元素
    *
    * @param element 要查找的元素
    * @return 是否包含的标志位
    * */
    public boolean contains(E element){
        for(int i=0;i<size;i++){
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    /*
    * 查找指定元素
    *
    * @param element 要查找的元素
    * @return 返回元素在data中的位置
    * */
    public int find(E element){
        for(int i=0;i<size;i++){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    /*
    * 删除index位置的元素，并返回删除的元素
    *
    * @param index 待删除的元素
    * @return 删除元素的值
    * */
    public E remove(int index){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("index的范围需要在[0,size)");
        }
        E ret = data[index];
        for(int i=index+1;i<size;i++){
            data[index] = data[index+1];
        }
        size--;
        data[size-1] = null;
        return null;
    }
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString(){
        return "Array"+
                "capacity="+ capacity+
                ",size="+size+
                ",data="+ Arrays.toString(data);
    }

}
