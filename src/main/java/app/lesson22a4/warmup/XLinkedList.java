package app.lesson22a4.warmup;

import java.util.StringJoiner;

public class XLinkedList {

  static class Node {
    final int value;
    Node next;


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
    if(curr==null) return 0;
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

  void reverse() {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      Node savedNext = curr.next; //
      curr.next = prev;
      prev = curr;       // moving to the next node
      curr = savedNext;  // moving to the next node
    }
    head = prev;
  }

  private Node reverser(Node curr, Node prev) {
    if (curr == null) return prev;
    Node savedNext = curr.next; //
    curr.next = prev;
    return reverser(savedNext, curr);
  }

  void reverser() {
    head = reverser(head, null);
  }

  void merge(Node head2) {
    Node merged;
    Node merged_head;
    XLinkedList merged_list;
    Node curr1=head;
    Node curr2=head2;
    if(head.value>head2.value)
      merged_head=head2;
    else
      merged_head=head;
    while(curr1!=null && curr2!=null){
      if(curr1.value>curr2.value){
        merged=curr2;
        curr2=curr2.next;
      }
      else {
        merged=curr1;
        curr1=curr1.next;
      }
      merged=merged.next;
    }
    while (curr1!=null){
      merged=curr1;
      merged=merged.next;
      curr1=curr1.next;
    }
    while (curr2!=null){
      merged=curr2;
      merged=merged.next;
      curr2=curr2.next;
    }
    head=merged_head;
  }

  void merge1(Node head2){
    Node curr1=head;
    Node curr2=head2;
    int i=0;
    while(curr1.next!=null && curr2.next!=null){
      if(curr1.value>curr2.value){
        this.insertBefore(i++,curr2.value);
        curr1=curr1.next.next;
        curr2=curr2.next;
      }
      else{
        curr1=curr1.next;
        i++;
      }
    }
    while (curr2!=null){
      this.insertAfter(i++,curr2.value);
      curr2=curr2.next;
    }
  }

  XLinkedList merge2(Node head2){
    XLinkedList merged_list = new XLinkedList();
    Node curr1 = head;
    Node curr2 = head2;
    while(curr1!=null && curr2!=null){
      if(curr1.value<curr2.value){
        merged_list.append(curr1.value);
        curr1=curr1.next;
      }
      else {
        merged_list.append(curr2.value);
        curr2=curr2.next;
      }
    }
    while(curr1!=null){
      merged_list.append(curr1.value);
      curr1=curr1.next;
    }
    while (curr2!=null){
      merged_list.append(curr2.value);
      curr2=curr2.next;
    }
    return merged_list;
  }

  boolean containsAt(int index, int element) {
    int index1=0;
    for(Node curr=head;curr!=null;curr=curr.next,index1++){
      if(index1==index && curr.value==element)
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
    if(index==0){
      Node newNode = new Node(value);
      newNode.next=head;
      head=newNode;
    }
    else {
      insertAfter(index-1,value);

  }}
}
