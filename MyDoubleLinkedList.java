package cn.list;

/**
 * @ClassName MyDoubleLinkedList
 * @Description 不带头结点的双链表（java内部的链表的实现形式）保存两个引用一个指向第一结点，一个指向最后一个结点。
 * @Auther danni
 * @Date 2019/7/26 10:43]
 * @Version 1.0
 **/

public class MyDoubleLinkedList {
    private  Dnode head=null;
    private  Dnode last=null;
    private int size=0;
    //头插法
    public void firstAdd(int datas ){
        Dnode temp=new Dnode(datas);
        if(head==null){
         head=temp;
         last=temp;
        } else{
           head.prev=temp;
           temp.next=head;
        }
        head=temp;
        size++;
    }
    //尾插法
    public void lastAdd(int datas){
      Dnode temp=new Dnode(datas);
      if(last==null){
          last=temp;
          head=temp;
      }else{
          last.next=temp;
          temp.prev=last;
          last=temp;
      }
     size++;
    }
    //任意位置插入_增加方法获取下标；
    public void  addindexDouble(int location,int data){
        if(location>size+1){
            System.err.println("位置无效插入失败");
        }
        if(location==1){
            this.firstAdd(data);
        }
        if(location==size+1){
            this.lastAdd(data);
        }
        Dnode node=new Dnode(data);
        Dnode temp=null;
        if(location<=size-location-1) {
          temp = this.getNode(location);
        }else {
            temp = this.getNode(location);
        }
            node.prev=temp.prev;
            node.next=temp;
            node.prev.next=node;
            node.next.prev=node;
        size++;
    }
    public Dnode getNode(int index){
        Dnode temp=null;
        if(index<=size-index-1){
             temp=head;
            for (int i = 1; i <index ; i++) {
                temp=temp.next;
            }
        }else{
            temp=last;
            for (int i = 1; i <= size-index; i++) {
                temp=temp.prev;
            }
        }
        return temp;
    }
    //头删法
    public void popFront(){
        if(size<=0){
            System.err.println("链表为空");
            return;
        }
        head=head.next;
        if(head==null){
            last=null;
        }
        else{
            head.prev=null;
        }
        size--;
    }
    //尾删法
    public void popBack(){
        if(size<=0){
            System.err.println("链表为空");
            return;
        }
        last=last.prev;
        if(last==null){
            head=null;
        }
        else{
            last.next=null;
        }
        size--;
    }
    //任意位置删除
    public void pop(int location){
        if(location<=0||location>size){
            System.err.println("位置无效");
            return;
        }
        if(location==1){
            this.popFront();
        }else if(location==size){
            this.popBack();
        }
        Dnode temp=null;
        if(location<=size-1-location){
            temp=this.getNode(location);
        }else{
            temp=this.getNode(location);
        }
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        size--;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains( int key){
        if(size<=0){
            System.err.println("链表为空");
            return false;
        }
        Dnode temp=head;
        while(temp!=null){
            if(temp.data==key){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    //正向打印双向链表
    public void printDoubleLinkedList_right(){
        Dnode temp=head;
        while(temp!=null){
            System.out.print(temp);
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    //反向打印双向链表
    public void printDoubleLinkedList_left(){
        Dnode temp=last;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.print(temp);
            temp=temp.prev;
        }
        System.out.println("null");
        System.out.println();
    }
    public static void main(String[] args) {
       MyDoubleLinkedList dl =new MyDoubleLinkedList();
        dl.firstAdd(1);
        dl.firstAdd(2);
        dl.firstAdd(3);
        dl.firstAdd(4);
        dl.lastAdd(5);
        dl.lastAdd(6);
        dl.lastAdd(7);
        dl.printDoubleLinkedList_right();
       // dl.popBack();
        //dl.popFront();
         dl.addindexDouble(3,10);
        dl.printDoubleLinkedList_right();
         dl.addindexDouble(5,11);
         dl.printDoubleLinkedList_right();
         dl.pop(3);
         dl.pop(5);
        //System.out.println( dl.contains(10));
        dl.printDoubleLinkedList_right();


    }
}
class Dnode{
    int data;
    Dnode prev=null;
    Dnode next=null;

    public Dnode(int data) {
        this.data = data;
    }


    public Dnode() {
    }
    public String toString(){
        return String.format("(Node%d)->",data);
    }
}
