package ru.qdts.edu.ls;

public class MemMon extends Thread {
	private boolean stop = false;
	
	public MemMon() {
		super();
		setDaemon(true);
	}

	public void run() {
		Runtime rt = Runtime.getRuntime();
		while (!stop) {
			System.out.printf("""
					*** Memory Monitor ***
					Max Memory = %d
					Total Memory = %d
					Free Memory = %d
					***********************
					""", rt.maxMemory(), rt.totalMemory(), rt.freeMemory());
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void finish() {
		stop = true;
	}
}
