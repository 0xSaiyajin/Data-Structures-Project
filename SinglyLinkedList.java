package StudentPackage;

/*
 *
 * @author Syra
 */
public class SinglyLinkedList<AnyType> 
{
    private int theSize;
    private Node<AnyType> begin;
    private Node<AnyType> temp;
    private String str;
    
    public SinglyLinkedList()
    {
        begin = new Node<AnyType>(null, null);
        temp = begin;
        theSize = 0;
        str = "";
    }
    
    public int theSize()
    {
        return theSize;
    }
    
    public void add(AnyType data)
    {
        if(theSize == 0)
        {
            begin.data = data;
            theSize++;
        }
        else
        {
            Node<AnyType> temp = begin;
            for(int i = 1; i < theSize; i++)
            {
                temp = temp.next;
            }
            temp.next = new Node(data, null);
            theSize++;
        }
    }
    
    public void remove(AnyType data)
    {
            if (theSize == 0)
            {
                System.out.println("Empty!");
            }
            else if(theSize == 1)
            {
                if (begin.data == data)
                {
                    begin = null;
                    theSize--;
                }
                else
                    System.out.println("Wrong id!");
            }
            else               
                {
                    if(begin.data == data)
                    {
                        temp = begin;
                        begin = temp.next;
                        temp = null;
                        theSize--;
                        
                    }
                    else
                    {
                        Node<AnyType> temp = begin;
                        Node<AnyType> holder = temp;
                        for(int j = 1; j < theSize;j++)
                        {
                            while(temp.next != null)
                            {
                                if(temp.next.data == data)
                                {
                                    holder = temp.next;
                                    temp.next = temp.next.next;
                                    holder = null;
                                    theSize--;
                                }
                                else
                                    temp = temp.next;
                            }
                        }
                    }
                }
    }
    public Node<AnyType> getNode(int index)
    {
        Node<AnyType> temp = begin;
        for(int j=0;j < index; j++)
        {
            temp = temp.next;
        }
        return temp;
    }
    public AnyType getData(Node<AnyType> cykablyad)
    {
        return cykablyad.data;
    }

    @Override
    public String toString()
    {
        Node holder = begin;
        while(holder != null)
        {
            str += holder.data.toString() + " ";
            holder = holder.next;
        }
        return str;
    }
    
    public class Node<AnyType>
    {
        public Node<AnyType> next;
        public AnyType data;
    
        public Node(AnyType d,Node<AnyType> n)
        {
            
            next = n;
            data = d;
        }
    }

}
