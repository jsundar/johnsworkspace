package com.test.producer.consumer.example;

public class MyProducer implements Runnable {
	
	protected MyBlockingQueue<Employee> queueObject;
	
	public MyProducer(MyBlockingQueue<Employee> queueObject) {
		this.queueObject = queueObject;
	}
	
	public void run() {
		try {
			int i=0;
			while(true) {
		        Thread.sleep(100); // simulate time passing during read
				queueObject.put(new Employee("name" + i++, i));
				System.out.println("Produced resource - Queue size now = "  + queueObject== null ? "0" : queueObject.size());
            }
        } catch (InterruptedException ex) {
            System.out.println("Producer INTERRUPTED");
        }
	}
}
