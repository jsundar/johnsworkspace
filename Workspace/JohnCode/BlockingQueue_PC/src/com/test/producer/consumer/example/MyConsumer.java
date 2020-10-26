package com.test.producer.consumer.example;

public class MyConsumer implements Runnable {

protected MyBlockingQueue<Employee> queueObject;
	
	public MyConsumer(MyBlockingQueue<Employee> queueObject) {
		this.queueObject = queueObject;
	}
	
	public void run() {
		try {
			Employee emp = queueObject.take();
			System.out.println("Produced resource - Queue size now = "  + queueObject == null ? "0"  : (queueObject.size() + " ******** : " + emp. getName() + " : " + emp.getAge()));
			Thread.sleep(100); // simulate time passing
        } catch (InterruptedException ex) {
            System.out.println("Consumer INTERRUPTED");
        }
	}
	

}
