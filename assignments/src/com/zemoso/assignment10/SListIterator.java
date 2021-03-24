package com.zemoso.assignment10;

@SuppressWarnings("rawtypes")
public class SListIterator<T>{
    Link head;
    Link currentNode;
    Link previousNode;

    public SListIterator(Link head) {
        this.head=head;
        currentNode =head;
    }

    void insert(T val){
        Link node = new Link(val,null);
        currentNode.next=node;
        previousNode = currentNode;
        currentNode =node;
    }

    void remove(){
        Link curr = head;
        int count = 0;
        Link nodeBeforePreviousNode = null;

        while(curr.next!=null){
            nodeBeforePreviousNode = previousNode;
            previousNode = curr;
            curr=curr.next;
            count++;
        }

        currentNode = previousNode;
        currentNode.next = null;
        previousNode = nodeBeforePreviousNode;

        if(count>0)
            System.out.println("Last link removed successfully");
        else
            System.out.println("No links to remove");

    }

    void iterate(){
        Link cur=head;
        while(cur!=null){
            if(cur!=head){
                System.out.print(" -> ");
            }
            System.out.print(cur.data);
            cur=cur.next;
        }
        System.out.println();
    }

}
