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
public class ArrayStack<T> implements StackInterface<T> {
    
    private T[] array;
    private int lastIndex;
    
    public ArrayStack(){
       this(DEFAULT_SIZE);
    }
    
    public ArrayStack(int n ){
        array = (T[])new Object[n];
        lastIndex = -1;
    }
    
    public void push(T newEntry){
        lastIndex++;
        //pre-condition : array must not be full
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
            array[i] = oldArray[i];
        }
    }
    
    public T pop(){
        
        T item = null;
        //pre-condition must not be empty
        if(!isEmpty()){
            item = array[lastIndex];
            array[lastIndex] = null;
            lastIndex--;
        }
        
        
        return item;
    }
    
    public T peek(){
         T item = null;
        //pre-condition must not be empty
        if(!isEmpty()){
            item = array[lastIndex];
            
        }
        return item;
    }
    
    private boolean isFull(){
        if(lastIndex == array.length)
            return true;
        else 
            return false;
        
    }
    
    public boolean isEmpty(){
         if(lastIndex == -1){
             return true;
         }
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
