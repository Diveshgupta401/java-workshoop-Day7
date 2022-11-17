package DaySevenf;

import java.util.Random;

public class Gamblersim {
	int stake = 100;

	public void putBet() {
		Random rnd = new Random();
		int reslt = rnd.nextInt(2);
		if (reslt == 0) {
			System.out.println("Lost bet of 1$!");
			stake--;
			System.out.println("Remaining money is " + stake + "$");
		} else {
			System.out.println("Won bet of 1$!");
			stake++;
			System.out.println("Remaining money is " + stake + "$");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gamblersim gm = new Gamblersim();
		String dcsn[] = new String[30];
		int reslts[] = new int[30];
		int max = 0;
		int min = 0;
		int luckyday = 0;
		int unluckyday = 0;
		int dayCount = 1;

		while(dayCount <= 30)
		{
			int startStake = gm.stake;
			int high = gm.stake + (int)Math.floor(0.5 * gm.stake);
			int low = gm.stake - (int)Math.floor(0.5 * gm.stake);
			while( !(gm.stake == high || gm.stake == low) )
			{
				gm.putBet();
			}
			System.out.println("Todays bet game for day "+ dayCount + " ended! Money is " + gm.stake+"$\n");
			if(gm.stake > startStake)
			{
				dcsn[dayCount-1] = "Won";
				reslts[dayCount-1] = gm.stake - startStake;
				if(max < (gm.stake - startStake))
				{
					max = gm.stake - startStake;
					luckyday = dayCount;
				}
			}
			else
			{
				dcsn[dayCount-1] = "Lost";
				reslts[dayCount-1] = startStake - gm.stake;
				if(min < (startStake - gm.stake))
				{
					min = startStake - gm.stake;
					unluckyday = dayCount;
				}
			}
			dayCount++;
		}
		
		System.out.println("\n Monthly Report \n ");
		for(int i=0;i<dcsn.length;i++)
		{
			System.out.println("Amount " + dcsn[i] + " for day " + (i+1) + " is "+ reslts[i] + "$");
		}
		
		System.out.println("Luckiest day is "+ luckyday+ " and amount won that day is "+ max);
		System.out.println("Unluckiest day is "+ unluckyday+ " and amount lost that day is "+ min);
	}

}
