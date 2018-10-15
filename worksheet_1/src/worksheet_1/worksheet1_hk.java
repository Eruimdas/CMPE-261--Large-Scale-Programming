package worksheet_1;

import java.util.ArrayList;
import java.util.Collections;

public class worksheet1_hk {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		//System.out.println(unionArrayList(list1,list2));
		//System.out.println(intersectionArrayList(list1,list2));
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("apple");
		list3.add("banana");
		list3.add("orange");
		list3.add("grape");
		System.out.println(reverseArrayList(list3));
		System.out.println(changeElements(list3,1,3));
	}
	private static ArrayList unionArrayList(ArrayList<Integer> mylist1, ArrayList<Integer> mylist2) {
		for(int i = 0; i < mylist1.size(); i++) {
			if(!doesContain(mylist2,mylist1.get(i))) mylist2.add(mylist1.get(i));
		}
	Collections.sort(mylist2);
	return mylist2;
	}
	
	private static ArrayList intersectionArrayList(ArrayList<Integer> mylist1, ArrayList<Integer> mylist2) {
		ArrayList<Integer> temp = new ArrayList<Integer>(); 
		for(int i = 0; i < mylist1.size(); i++) {
			if(mylist2.contains(mylist1.get(i))) temp.add(mylist1.get(i));
		}
		return temp;
	}
	
	private static ArrayList<String> reverseArrayList(ArrayList<String> mylist1){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = mylist1.size()-1; i >= 0; i--) {
			temp.add(mylist1.get(i));
		}
		
		return temp;
	}
	
	private static ArrayList<String> changeElements(ArrayList<String> mylist1, int ind1, int ind2){
		String a = mylist1.get(ind1);
		String b = mylist1.get(ind2);
		
		mylist1.remove(ind1);
		mylist1.remove(ind2-1);
		
		mylist1.add(ind1-1, b);
		mylist1.add(ind2-1, a);
		
		return mylist1;
	}
	
	private static boolean doesContain(ArrayList<Integer> mylist1, int number) {
		boolean result = false;
		for(int i = 0; i < mylist1.size(); i++) {
			if(mylist1.get(i) == number) { result=true; break;}
		}
		return result;
	}
}

