package com.logicmojo.LinkedList;

public class SplitLinkedList {

    public static Node[] splitLinkedList(Node head) {
      int i = 1;
      Node curr = head;
      Node oddNode = new Node(-1);
      Node evenNode = new Node(-1);
      Node oddPointer = oddNode.next;
      Node evenPointer = evenNode.next;
      while (curr != null) {
          if (i % 2 != 0) {
              oddPointer = curr;
              oddPointer = oddPointer.next;
          } else {
              evenPointer = curr;
              evenPointer = evenPointer.next;
          }
          curr = curr.next;
          i++;
      }
      oddPointer.next = null;
      evenPointer.next = null;
      return new Node[] {oddNode, evenNode};
    }
}
