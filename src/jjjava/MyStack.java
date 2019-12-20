package jjjava;

import java.util.Arrays;

/**
 * @Author : LoneKing
 * @Description:
 * @Date: Created in 8:57 2019/11/4
 * @Modified By: LoneKing
 * @Blame: LoneKing
 */
public class MyStack<T> {
    //栈容量
    private int capacity;
    //栈中元素数量
    private int count;
    //数栈据
    private Object[] storage;
    private static final int GROW_FACTOR = 2;

    public MyStack() {
        this.capacity = 8;
        this.count = 0;
        this.storage = new Object[this.capacity];
    }

    public MyStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity too small");
        }
        this.capacity = capacity;
        this.count = 0;
        this.storage = new Object[this.capacity];
    }

    public void push(T e) {
        if (count == capacity) {
            this.ensureCapaticy();
        }
        this.storage[this.count++] = e;
    }

    private T pop() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return (T) this.storage[--count];
    }

    private T peek() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return (T) this.storage[count - 1];
    }

    private void ensureCapaticy() {
        int newCapacity = this.capacity * GROW_FACTOR;
        this.storage = Arrays.copyOf(this.storage, newCapacity);
        capacity = newCapacity;
    }

    private boolean isEmpty() {
        return this.count == 0;
    }

    private int size() {
        return this.count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.count; i++) {
            sb.append("," + ((T) this.storage[i]).toString());
        }
        if (this.count > 0) {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.count);
        System.out.println(stack.capacity);
        for (int i =0;i<999;i++)
        {
            stack.push("b");
        }
        System.out.println(stack);
        System.out.println(stack.count);
        System.out.println(stack.capacity);
    }


}
