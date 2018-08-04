package exam3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RandomMap {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		addRandomNnumber(list);
		System.out.print("随机生成50个小于100的数,分别为:");
		int size = list.size();
		for(int l:list){
			if(size>1){
				System.out.print(l+",");
			}else{
				System.out.print(l);
			}
			size--;
		}
		System.out.println();
		HashMap<Integer, ArrayList<Integer>> hm=new HashMap<Integer, ArrayList<Integer>>();
		printRandomMap(hm,list);
	}
	private static void printRandomMap(HashMap<Integer, ArrayList<Integer>> hm,List<Integer> list) {
		put(hm,list,1);
		put(hm,list,2);
		put(hm,list,3);
		put(hm,list,4);
		put(hm,list,5);
		put(hm,list,6);
		put(hm,list,7);
		put(hm,list,8);
		put(hm,list,9);
		System.out.print("Map中的数据为：");
		print(hm);
		System.out.println();
		System.out.print("排序后的Map为:");
		printSorted(hm);
	}
	/**
	 *排序前打印 
	 */
	private static void print(HashMap<Integer, ArrayList<Integer>> hm) {
		Iterator iter = hm.entrySet().iterator();
		System.out.print("{");
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			int key = (int) entry.getKey();
			ArrayList<Integer> val = (ArrayList<Integer>) entry.getValue();
			System.out.print(key+"=>");
			int size = val.size();
			for(int a:val){
				if(size==val.size()){
					System.out.print("["+a+",");
				}else if(size==1){
					if(iter.hasNext()){
						System.out.print(a+"],");
					}else{
						System.out.print(a+"]");
					}
				}else{
					System.out.print(a+",");
				}
				size--;
			}
		}
		System.out.print("}");
	}
	/**
	 *排序后打印 
	 */
	private static void printSorted(HashMap<Integer, ArrayList<Integer>> hm) {
		Iterator iter = hm.entrySet().iterator();
		System.out.print("{");
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			int key = (int) entry.getKey();
			ArrayList<Integer> val = (ArrayList<Integer>) entry.getValue();
			Collections.sort(val);
			System.out.print(key+"=>");
			int size = val.size();
			for(int a:val){
				if(size==val.size()){
					System.out.print("["+a+",");
				}else if(size==1){
					if(iter.hasNext()){
						System.out.print(a+"],");
					}else{
						System.out.print(a+"]");
					}
				}else{
					System.out.print(a+",");
				}
				size--;
			}
		}
		System.out.print("}");
	}
	/**
	 *把相应的数放入map中 
	 */
	private static void put(HashMap<Integer, ArrayList<Integer>> hm,List<Integer> list,int key) {
		// TODO Auto-generated method stub
		List<Integer> rlist=new ArrayList<Integer>();
		for(int i =0;i<list.size();i++){
			if(list.get(i)/10==key||(list.get(i)<10&&list.get(i)%10==key)){
				rlist.add(list.get(i));
			}
		}
		if(!(rlist==null)&&!rlist.isEmpty()&&!(rlist.size()==0)){
			hm.put(key, new ArrayList<Integer>(rlist));
		}
	}
	/**
	 * 生成50个0~100内的随机数，存放到一个ArrayList中
	 */
    public static void addRandomNnumber(List<Integer> list) {
 
        for (int i = 0; i < 50; i++) {
 
            int ii = (int) ((Math.random()) * 101);
            list.add(ii);
        }
    }

}
