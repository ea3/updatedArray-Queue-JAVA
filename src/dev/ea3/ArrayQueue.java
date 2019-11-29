package dev.ea3;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee [] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        this.queue = new Employee[capacity];
    }

    public void add(Employee employee){
        if(size() == this.queue.length - 1){
            int numItems = size();
            Employee[] newArray = new Employee[2 * this.queue.length];

            System.arraycopy(this.queue, this.front, newArray,0 , this.queue.length - this.front);
            System.arraycopy(this.queue, 0, newArray,this.queue.length - this.front , this.back);

            this.queue = newArray;

            this.front = 0;
            this.back = numItems;
        }

        this.queue[this.back] = employee;

        if(this.back < this.queue.length - 1){
            this.back++;
        }else{
            this.back = 0;
        }
    }

    public Employee remove(){

        if(size() == 0){
            throw new NoSuchElementException();
        }

        Employee employee = this.queue[this.front];
        this.queue[this.front] = null;
        this.front++;

        if(size() == 0){
            this.front = 0;
            this.back = 0;
        }else if(this.front == this.queue.length){
            this.front = 0;
        }

        return employee;
    }

    public Employee peek(){

        if(size() == 0){
            throw new NoSuchElementException();
        }

        return this.queue[this.front];
    }


    public int size(){

        if(this.front <= this.back){
            return this.back - this.front;
        }else{
            return this.back - this.front + this.queue.length;
        }

    }


    public void printQueue(){
        if(this.front <= this.back){
            for(int i = this.front; i <this.back; i++){
                System.out.println(this.queue[i]);
            }
        }else{
            for(int i = this.front; i < this.queue.length; i++){
                System.out.println(this.queue[i]);
            }
            for(int i = 0; i< this.back; i++ ){
                System.out.println(queue[i]);
            }
        }
    }
}
