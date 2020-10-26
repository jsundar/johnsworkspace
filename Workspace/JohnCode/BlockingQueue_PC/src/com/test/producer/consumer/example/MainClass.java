package com.test.producer.consumer.example;

public class MainClass {
	public static void main(String[] args) {
		int numProducers = 4;
        int numConsumers = 3;
         
        MyBlockingQueue<Employee> myQueue = new MyBlockingQueue<>(20);
         
        for (int i = 0; i < numProducers; i++){
            new Thread(new MyProducer(myQueue)).start();
        }
             
        for (int i = 0; i < numConsumers; i++){
            new Thread(new MyConsumer(myQueue)).start();
        }
 
        // Let the simulation run for, say, 10 seconds
        try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        // End of simulation - shut down gracefully
        System.exit(0);
	}

}
