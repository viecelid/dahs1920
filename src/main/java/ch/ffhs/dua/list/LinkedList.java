package ch.ffhs.dua.list;

import java.util.Iterator;
import java.util.List;

public class LinkedList<E> extends ListBasic<E> implements List<E>
{
    private Node<E> anker;
    private Node<E> helper;
    private int length=0;
    @Override
    public int size()
    {
        return length;
    }

    @Override
    public boolean isEmpty()
    {
        if (anker==null){
            return true;
        }
        // TODO
    	return false;
    }
    
    @Override
    public E get(int index)
    {
        //falls Index 0 ist können wir gleich den Anker zurückgeben
        if (index==0){
            return anker.element;
        }
        //wir suchen nach dem Index und fangen beim Anker an, welcher dem Index 0 entspricht
        helper=anker;
        int i=0;
        while (helper.next!=null){
            i=i+1;
            helper=helper.next;
            if (index==i){
                return helper.element;
            }
        }

        // TODO
    	return null;
    }


    @Override
    public E set(int index, E element)
    {
        //falls Index 0 ist können wir gleich den Anker zurückgeben
        if (index==0){
            return anker.element=element;
        }
        //wir suchen nach dem Index und fangen beim Anker an, welcher dem Index 0 entspricht
        helper=anker;
        int i=0;
        while (helper.next!=null){
            i=i+1;
            helper=helper.next;
            if (index==i){
                helper.element=element;
                return helper.element;
            }
        }
        // TODO
        return null;
    }
    
    
    @Override
    public boolean add(E element)
    {
        //erstellen eines Nodes und den Wert eintragen
        Node<E> lln=new Node();
        lln.element=element;
        //Falls Liste leer ist machen wir den ersten Node
        if(this.isEmpty()){
            lln.prev=null;
            lln.next=null;
            anker=lln;
        }
        else{
            //ersten Node holen und als Anker setzen
            helper=anker;
            //der helper traversiert nun die Liste bis er am Schluss ankommt
            while (helper.next!=null){
                helper=helper.next;
            }
            //verlinken vom neuen Node
            lln.prev=helper;
            lln.next=null;
            helper.next=lln;
        }
        // TODO
        length++; //list increases by one
        return true;
    }

    @Override
    public void add(int index, E element)
    {
        //falls Index 0 ist können wir gleich den Anker zurückgeben
        Node<E> lln=new Node();
        lln.element=element;
        length++; //Liste ist gewachsen

        //wir suchen nach dem Index und fangen beim Anker an, welcher dem Index 0 entspricht
        helper=anker;
        int i=0;
        if (index==0){
            lln.next=helper;
            lln.prev=null;
            helper.prev=lln;
            anker=lln;
            return;
        }

        while (helper.next!=null){
            i=i+1;
            helper=helper.next;
            if (index==i){
                helper.prev.next=lln;
                lln.prev=helper.prev;
                helper.prev=lln;
                lln.next=helper;

            }
        }
        //TODO     
    }

    
    public boolean contains(Object o)
    {
        //wir suchen nach dem Index und fangen beim Anker an, welcher dem Index 0 entspricht
        helper=anker;
        while (helper.next!=null) {
            helper = helper.next;
            if (helper.element == o) {
                return true;
            }
        }

    	return false;
    }

    @Override
    public E remove(int index)
    {
        if (this.isEmpty()){
            return null;
        }
        length--; //Liste ist gewachsen
        //wir suchen nach dem Index und fangen beim Anker an, welcher dem Index 0 entspricht
        helper=anker;
        int i=0;
        if (index==0){
            anker=helper.next;
            anker.prev=null;
            return helper.element;
        }

        while (helper.next!=null){
            i=i+1;
            helper=helper.next;
            if (index==i){
                helper.prev.next=helper.next;
                helper.next.prev=helper.prev;
                return helper.element;
            }
        }
            // TODO
        return null;
    }
    
    @Override
    public boolean remove(Object o)
    {
        if (this.isEmpty()){
            return false;
        }
        length--; //Liste ist gewachsen
        // TODO
    	return false;
    }

    @Override
    public void clear()
    {
        length=0;
        // TODO
    }

    @Override
    public Iterator<E> iterator()
    {
        return new LinkedListIterator();
    }
    
 // Die anderen Methoden des List-Interfaces müssen nicht implementiert werden.
    
///////////////////////////////////////////////////
    
   

    private static class Node<E>
    {
        E element;
        Node<E> next;
        Node<E> prev;
    }
    
    private class LinkedListIterator implements Iterator<E>
    {
       
        @Override
        public boolean hasNext()
        {
            // TODO
        	return false;
        }

        @Override
        public E next()
        {
            // TODO
            return null;
        }
        
        @Override
        public void remove()
        {
           // TODO
        }
    }
    

}
