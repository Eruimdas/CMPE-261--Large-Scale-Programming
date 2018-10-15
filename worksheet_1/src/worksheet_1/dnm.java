package worksheet_1;

import java.util.Random;

public class dnm {
 public static void main(String[] args) {
	 Random rand = new Random();
	 int hasan = 0;
	 int berke = 0;
	 int berkin = 0;
	 int[] names = {hasan,berke,berkin};
	 
	 for(int i = 0; i < 100; i++) {
		 int x = rand.nextInt(3);
		 if(x == 0) {
			 hasan++;
		 }
		 else if(x == 1) {
			 berke++;
		 }
		 else {
			 berkin++;
		 }
	 }
	 System.out.println("hasan: " + hasan);
	 System.out.println("berke: " + berke);
	 System.out.println("berkin: " + berkin);
}

}
