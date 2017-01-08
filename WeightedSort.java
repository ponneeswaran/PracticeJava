import java.util.*;

public class WeightedSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		String[] n = st.split(" ");
		Integer[] weight = new Integer[n.length];
		for(int i=0;i<n.length;i++){
			weight[i]=sumOfDigits(n[i].toCharArray());
		}
		
		mergeSort(n,weight,0,n.length-1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n.length;i++){
			if(i>0)
				sb.append(" ");
			sb.append(n[i]);
		}
		System.out.println(sb.toString());
		
		sc.close();
	}
	
	private static int sumOfDigits(char[] n){
		int sum = 0;
		for(int i=0;i<n.length;i++){
			sum+=Character.getNumericValue(n[i]);
		}
		return sum;
	}
	
	private static void mergeSort( String[] n, Integer[] weight, int p, int r){
		if(p<r){
			int q = (p+r)/2;
			mergeSort(n, weight, p, q);
			mergeSort(n, weight, q+1, r);
			merge(n,weight,p,q,r);
		}
	}
	
	private static void merge(String[] n, Integer[] weight, int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int w1 = n1;
		int w2 = n2;
		int i,j;
		
		String[] ln = new String[n1+1];
		String[] rn = new String[n2+1];
		Integer[] lw = new Integer[w1+1];
		Integer[] rw = new Integer[w2+1];
		
		for(i=0;i<n1;i++){
			ln[i] = n[p+i];
			lw[i] = weight[p+i];
		}
		
		for(j=0;j<n2;j++){
			rn[j] = n[q+j+1];
			rw[j] = weight[q+j+1];
		}
		
		ln[n1]="999999999";
		rn[n2]="999999999";
		lw[n1]=999999999;
		rw[n2]=999999999;
		i=0;
		j=0;
		
		for(int k=p;k<=r;k++){
			if(lw[i]<rw[j]){
				n[k] = ln[i];
				weight[k] = lw[i];
				i+=1;
			}
			else if(lw[i]==rw[j]){
				if(ln[i].compareTo(rn[j])<=0){
					n[k] = ln[i];
					weight[k] = lw[i];
					i+=1;
				}else{
					n[k] = rn[j];
					weight[k] = rw[j];
					j+=1;
				}
			}
			else{
				n[k] = rn[j];
				weight[k] = rw[j];
				j+=1;
			}
		}
	}
}
