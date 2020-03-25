package app.lesson22a4.warmup;

import java.util.StringJoiner;

public class XLinkedList {

  static class Node {
    final int value;
    Node next;
    Node prev;

    Node(int value) {
      this.value = value;
    }

    Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  Node head;

  void prepend(int value) {
    Node node = new Node(value);
    node.next = head;
    head = node;
  }

  void prepend2(int value) {
    Node node = new Node(value, head);
    head = node;
  }

  void prepend3(int value) {
    head = new Node(value, head);
  }

  void append(int value) {
    Node node = new Node(value);
    if (head == null) {
      head = node;
    } else {
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = node;
    }
  }

  public String represent() {
    StringJoiner sj = new StringJoiner(",", "LL:(", ")");
    Node curr = head;
    while (curr != null) {
      sj.add(String.valueOf(curr.value));
      curr = curr.next;
    }
    return sj.toString();
  }

  public String represent2() {
    StringJoiner sj = new StringJoiner(",", "LL:(", ")");
    for (Node curr = head; curr != null; curr = curr.next) {
      sj.add(String.valueOf(curr.value));
    }
    return sj.toString();
  }

  private void attach_next(Node curr, StringJoiner sj) {
    if (curr == null) return;
    sj.add(String.valueOf(curr.value));
    attach_next(curr.next, sj);
  }

  public String represent3r() {
    StringJoiner sj = new StringJoiner(",", "LL:(", ")");
    attach_next(head, sj);
    return sj.toString();
  }

  int size() {
    int size=0;
    for(Node curr=head;curr!=null;curr=curr.next){
      size++;
    }
    return size;
  }

  int sizer() {
    //return countHR(head);
    return countTR(head,0);
  }

  int countHR(Node curr) {
    if(curr.next==null) return 1;
    return 1+countHR(curr.next);
  }

  int countTR(Node curr, int count){
    if(curr==null) return count;
    return countTR(curr.next,++count);
  }

  boolean contains(int element) {
    for(Node curr=head;curr!=null;curr=curr.next){
      if(curr.value==element)
        return true;
    }
    return false;
  }

  boolean containsr(int element) {
    return check(head,element);
  }

  boolean check(Node curr, int element){
    if(curr==null) return false;
    else if(curr.value==element) return true;
    return check(curr.next,element);
  }

  void reverse() {}
  void reverser() {}

  void merge(Node head2) {
    if(head==null)
      head=head2;
    else{
      Node curr = head;
      while(curr.next!=null){
        curr=curr.next;
      }
      curr.next=head2;
    }
  }

  boolean containsAt(int index, int element) {
    int index1=0;
    for(Node curr=head;curr!=null;curr=curr.next,index1++){
      if(curr.value==element && index1==index)
        return true;
    }
    return false;
  }

  void deleteHead() {
    head=head.next;
  }

  void deleteTail() {
    Node curr = head;
    while (curr.next.next!=null)
      curr = curr.next;
    curr.next=null;
  }

  void deleteAt(int index) {
    Node curr=head;
    if(index==0)
      deleteHead();
    else {
      for (int i = 0; i < index - 1; i++) {
        curr = curr.next;
      }
      if (curr.next == null)
        deleteTail();
      curr.next = curr.next.next;
    }}

  void deleteValue(int value) {
    Node curr = head;
    while(curr.next.value!=value){
      curr=curr.next;
    }
    curr.next=curr.next.next;
  }

  void insertAfter(int index, int value) {
    Node curr=head;
    Node newNode = new Node(value);
    for(int i=0;i<index;i++)
      curr=curr.next;
    newNode.next=curr.next;
    curr.next=newNode;
  }

  void insertBefore(int index, int value) {
    Node newNode = new Node(value);
    if(index==0){
      newNode.next=head;
      head=newNode;
    }
    else {
      Node curr=head;
      for(int i=0;i<index-1;i++)
        curr=curr.next;
      newNode.next=curr.next;
      curr.next=newNode;

  }}
}
