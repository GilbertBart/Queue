package edu.upc.eetac.dsa;

public class QueueImpl<E> implements Queue<E>{
    private E[] data;
    private int size =0; // nº elements dins vect
    private int capacity;

    public QueueImpl(int n) {
        this.data= (E[]) new Object[n];
        size =0;
        capacity =n;

    }

    @Override
    public void push(E e) throws FullQueueException {
        if (isFull())
        {
            throw new FullQueueException();
        }
        else {
            data[size] = e;
            size = size + 1;
        }
    }

    @Override
    public E pop() throws EmptyQueueException {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        else {
            E poped = data[0];
            int i = 0;
            while (i < size) {
                data[i] = data[i + 1];
                i = i + 1;
            }
            size = size - 1;
            return poped;
        }

    }

    @Override
    public int size() {
        return size;
    }

    public boolean isFull(){ return (capacity)==size;}
    public boolean isEmpty(){ return (size)==0;}
}
