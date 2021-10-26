package et.ticketingsystem.ts.util;

public class BatchRunner implements Runnable{
	
	
	public BatchRunner(){}

	@Override
	public void run() {
	
		try {
			//Thread.sleep(10000);
			//while(true)
			updateSystem();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
   public void updateSystem() {
	   
	   System.out.print("E T T... updating system....");
   }
	

}
