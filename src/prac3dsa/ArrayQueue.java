package prac3dsa;


public class ArrayQueue<T> implements QueueInterface<T>{
    
    T[] array;
    int firstIndex , lastIndex;
    
    
    public ArrayQueue(){
        array = (T[])new Object[5];
        firstIndex = 0;
        lastIndex = -1;
    }
    
    public void enqueue(T newEntry){
        lastIndex++;
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
     
     
    public T dequeue(){
        T item = null ;
        //Pre condition make sure not empty
        if(!isEmpty()){
            item = array[firstIndex];
            firstIndex++;
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
       if(lastIndex == array.length)
           return true;
       else
           return false;
       
    }
    
    public boolean isEmpty(){
        if(lastIndex + 1 == firstIndex)
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
