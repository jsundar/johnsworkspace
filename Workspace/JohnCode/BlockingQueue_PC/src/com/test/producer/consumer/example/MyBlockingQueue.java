package com.test.producer.consumer.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
	
	private int max;
	private Queue<E> queue = new LinkedList<>();
	private ReentrantLock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	public MyBlockingQueue(int size) {
		queue = new LinkedList<>();
		this.max = size;
	}
	
	public void put(E e) {
		try {
			lock.lock();
			while(queue.size() == max) {
				notFull.wait();
			}
			queue.add(e);
			notEmpty.signalAll();

		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			lock.unlock();
		}
	} 

	public E take() {
		E item = null;
		try {
			lock.lock();
			while(queue.size() == 0) {
				notEmpty.wait();
			}
			item = queue.remove();
			notFull.signalAll();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			lock.unlock();
		}
		return item;
		
	}
	
	public int size() {
		return queue.size();
	}
}
