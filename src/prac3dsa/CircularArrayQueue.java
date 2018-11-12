/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac3dsa;

/**
 *
 * @author Tarc
 */
public class CircularArrayQueue<T> implements QueueInterface<T> {
    
    T[] array;
    int firstIndex , lastIndex;
    
    
    public CircularArrayQueue(){
        array = (T[])new Object[5];
        firstIndex = 0; 
        lastIndex = -1;
    }
    
    public void enqueue(T newEntry){
        lastIndex=(lastIndex+1)%array.length;
        if(isFull()){
            expandArray();
        }
        array[lastIndex] = newEntry;
    }
    
     private void expandArray(){
        T[] oldArray = array;
        int size = oldArray.length;
        
        array = (T[])new Object[2*size];
        
        for(int i = 0 ; i < size ; i++){
            array[i] = oldArray[firstIndex];
            if((firstIndex+1)%oldArray.length == 0){
                firstIndex = 0 ;
            }else
            firstIndex++;
        }
    }
     
     
    public T dequeue(){
        T item = null ;
        //Pre condition make sure not empty
        if(!isEmpty()){
            item = array[firstIndex];
            firstIndex=(firstIndex+1)%array.length;
        }
        return item;
        
    }
    public T getFront(){
        T item = null ;
        //Pre condition make sure not empty
        if(!isEmpty()){
            item = array[firstIndex];
        }
        return item;
    }
    
    private boolean isFull(){
       if(((lastIndex+1)%array.length) == firstIndex)
           return true;
       else
           return false;
       
    }
    
    public boolean isEmpty(){
        if(((lastIndex+2)%array.length) == firstIndex)
            return true;
        else 
            return false;
        
    }
    
    public void clear(){
        for(int i = 0 ; i < array.length ; i++){
            array[i] = null;
        }
        lastIndex = -1 ;
    }
    
}
