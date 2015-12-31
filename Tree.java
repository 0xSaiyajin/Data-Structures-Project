package StudentPackage;

/**
 *
 * @author Syra
 * @param <E>
 */
public class Tree<E> 
{
    private int theSize;
    private String str;
    public Node root;
    public Node temp;
    public int left_right;
    private boolean found;
    private int hopCount;
    
    public Tree()
    {
        root = null;
        temp = root;
        theSize = 0;
        str ="";
    }
    public void clearList()
    {
        str = "";
    }
    public void clearHopCount()
    {
        hopCount = 0;
    }
    public int NodeDataFind(int data)
    {
        if(size() > 0)
        {
            Node temp = findNode(getRoot(), data);
            if(temp == null)
            {
                hopCount = -1;
                return -1;
            }
            else
                return temp.data;
        }
        else
            return -1;
    }
    public int getHops()
    {
        return hopCount;
    }
    public int getData(Node node)
    {
        return node.data;
    }
    public int size()
    {
        return theSize;
    }
    public Node getRoot()
    {
        return root;
    }
    public void InsertNode(int id)
    {
        if(theSize == 0)
        {
           root = new Node(id,null,null);
           theSize++;
        }
        else
        {
            Node<E> temp = NodePlace(getRoot(), id);
            if(left_right == -1)
            {
                temp.left = new Node(id, null, null);
            }
            else
            {
                temp.right = new Node(id, null, null);
            }
            theSize++; 
        }
    }

    public Node NodePlace(Node node, int data)
    {
        if (node.data > data)
        {
            left_right = -1;
            if(node.left == null)
            {
                return node;
            }
            else
            {
                return NodePlace(node.left , data);
            }
        }
        else
        {
            left_right = 1;
            if(node.right == null)
            {
                return node;
            }
            else
            {
                return NodePlace(node.right , data);
            }
        }        
    }
    public Node findNode(Node node,int data)
    {
        found = false;
        left_right = 0;
        if(node.data == data)
        {
            found = true;
            left_right = 2;
            return node;
        }
        else if(node.data > data && node.left != null)
        {
            if(node.left.data == data)
            {
                hopCount++;
                found = true;
                left_right = -1;
                return node;
            }
            else
            {
                hopCount++;
                return findNode(node.left, data);
            }   
        }
        else if(node.data < data && node.right != null)
        {
            if(node.right.data == data)
            {
                hopCount++;
                found = true;
                left_right = 1;
                return node;
            }
            else
            {
                hopCount++;
                return findNode(node.right, data);
            }
        }
        else
            return null;
    }
    public Node getMax(Node node)
    {
        if(node.right == null)
        {
            return node;
        }
        else
            return getMax(node.right);
    }
    public Node getMin(Node node)
    {
        if(node.left == null)
        {
            return node;
        }
        else return getMin(node.left);
    }
    public void removeNode(int data)
    {
        if(size() > 0)
        {
            Node temp = findNode(getRoot(), data);
            if (found == true)
            {
                if(left_right == 2)
                {
                    if(root.left == null && root.right == null)
                    {
                        root = null;
                        theSize--;
                    }
                    else if(root.left != null && root.right !=null)
                    {
                        temp = getMax(root.left);
                        Node temp2 = findNode(getRoot().left , temp.data);
                        if(left_right == 2)
                        {
                            root.left = null;
                        }
                        else
                        {
                            Node temp3 = findNode(getRoot() , data);
                            temp2.right = null;
                            temp2 = getMin(temp);
                            temp2.left = temp3.left;
                        }
                    }
                    else
                    {
                    Node temp2 = root;
                    temp.right = root.right;
                    root = temp;
                    temp2 = null;
                    theSize--;
                    }
                }
                else
                {
                    if(root.left == null)
                    {
                        temp = getMin(root.right);
                        Node temp2 = findNode(getRoot().right, temp.data);
                        if(left_right == 2)
                        {
                            root.right = null;
                        }
                        else
                        {
                            temp2.left = null;
                            temp2 = root;
                            temp.right = root.right;
                        }
                        root = temp;
                        temp2 = null;
                        theSize--;
                    }
                    else
                    {
                        temp = getMax(root.left);
                        Node temp2 = findNode(getRoot().left, temp.data);
                        if(left_right == 2)
                        {
                            root.left = null;
                        }
                        else
                        {
                            temp2.right = null;
                            temp2 = root;
                            temp.left = root.left;
                        }
                        root = temp;
                        temp2 = null;
                        theSize--;
                    }
                }
            }
            else if(left_right == -1)
            {
                if(temp.left.left == null && temp.left.right == null)
                    {
                        temp.left = null;
                        temp = null;
                        theSize--;
                    }
                else if(temp.left.left != null && temp.left.right != null)
                {
                    Node temp2 = getMax(temp.left.left);
                    Node temp3 = findNode(temp.left.left, temp2.data);
                    Node temp4 = findNode(getRoot() ,data);
                    if(left_right == 2)
                    {
                        temp4.left.left = null;
                    }
                    else
                    {
                        temp3.right = null;
                        temp3 = getMin(temp2);
                        temp2.left = temp4.left.left;
                    }
                    temp2.right = temp.left.right;
                    temp3 = temp.left;
                    temp.left = temp2;
                    temp3 = null;
                    theSize--;
                }
                else
                {
                    Node temp2 = temp.left;
                    temp.left = null;
                    if(temp2.left != null)
                        temp.left = temp2.left;
                    else
                        temp.left = temp2.right;
                    temp2 = null;
                    theSize--;
                }
            }
            else
            {
                if(temp.right.left == null && temp.right.right == null)
                    {
                        temp.right = null;
                        temp = null;
                        theSize--;
                    }
                else if(temp.right.left != null && temp.right.right != null)
                {
                        Node temp2 = getMax(temp.right.left);
                        Node temp3 = findNode(temp.right.left, temp2.data);
                        if(left_right == 2)
                        {
                            Node temp4 = findNode(getRoot(), data);
                            temp4.right.left = null;
                        }
                        else
                        {
                            Node temp4 = findNode(getRoot(), data);
                            temp3.right = null;
                            temp3 = getMin(temp2);
                            temp3.left = temp4.right.left;
                        }
                        temp2.right = temp.right.right;
                        temp3 = temp.right;
                        temp.right = temp2;
                        temp3 = null;
                        theSize--;
                }
                else
                {
                        Node temp2 = temp.right;
                        temp.right = null;
                        if(temp2.left != null)
                            temp.right = temp2.left;
                        else
                            temp.right = temp2.right;
                        temp2 = null;
                        theSize--;
                }
            }
        }
    }
    public String PostOrder(Node node)
    {
        if(node != null)
        {
            PostOrder(node.left);
            PostOrder(node.right);
            str += Integer.toString(node.data) + " ";
        }
        return str;
    }
    public String PreOrder(Node node)
    {
        if(node != null)
        {
            str += Integer.toString(node.data) + " ";
            PreOrder(node.left);
            PreOrder(node.right);
        }
        return str;
    }
    public String InOrder(Node node)
    {
        if(node != null)
        {
            InOrder(node.left);
            str += Integer.toString(node.data)+ " ";
            InOrder(node.right);
        }
        return str;
    }
    public class Node<E>
    {
        public Node<E> left;
        public Node<E> right;
        public int data;
        
        public Node(int id,Node<E> leftChild,Node<E> rightChild)
        {
            data = id;
            right = rightChild;
            left = leftChild;
        }
         public int getData()
        {
            return data;
        }
         public Node getLeftChild()
         {
             return left;
         }
         public Node getRightChild()
         {
             return right;
         }
    }
}
