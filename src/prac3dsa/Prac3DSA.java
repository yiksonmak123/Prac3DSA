package prac3dsa;


public class Prac3DSA {


    public static void main(String[] args) {
       
        StackInterface<Character> cStack = new ArrayStack();
        QueueInterface<Character> cQueue = new ArrayQueue();
        QueueInterface<Character> cQueue2 = new CircularArrayQueue();
        String s = "abcd";
        char c;
        
        for(int i = 0 ; i < s.length(); i++){
            c = s.charAt(i);
            cStack.push(c);
            cQueue.enqueue(c);
            cQueue2.enqueue(c);
        }
        System.out.println("Stack : ");
        while(!cStack.isEmpty()){
            System.out.print(cStack.pop());
        }
        
        System.out.println("\nQueue : ");
        while(!cQueue.isEmpty()){
            System.out.print(cQueue.dequeue());
        }
        
        System.out.println("\nQueue 2: ");
        while(!cQueue.isEmpty()){
            System.out.print(cQueue2.dequeue());
        }
        
        
    }
    
}
