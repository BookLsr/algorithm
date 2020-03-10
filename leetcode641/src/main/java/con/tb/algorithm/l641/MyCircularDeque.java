package con.tb.algorithm.l641;


/**
 * @Description:
 * @Author: WindPursuer
 * @Date 2020/3/10 9:20 PM
 */
public class MyCircularDeque {

    int[] arr;
    int front;
    int tail;

    int k;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        /**
         * 初始化队列大小
         */
        arr = new int[k + 1];

        /**
         * 尾部指针，新增则 赋值 --
         */
        tail = 0;
        /**
         * 头部指针，指向当前， 新增则 ++ 赋值
         */
        front = 0;

        this.k = k + 1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + k) % k;
        arr[front] = value;
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[tail] = value;
        tail = (tail + 1) % k;
        return true;

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % k;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + k) % k;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(tail - 1 + k) % k];


    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == tail;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail + 1) % k == front;
    }


    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        System.out.println(circularDeque.insertLast(1));
    }
}
