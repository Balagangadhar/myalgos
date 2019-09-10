package com.bala.ds;

public class LinkedList<T extends Comparable<T>> {

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(LinkedList.Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
}
