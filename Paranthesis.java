import java.util.Scanner;
import java.util.Stack;

/**
 * 
 */

/**
 * @author Ponneeswaran
 *
 */
public class Paranthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		boolean balanced = true;
		Stack<Character> stack = new Stack<>();
		
		char[] chArr = input.toCharArray();
		for(int i=0;i<chArr.length;i++){
			if( chArr[i]=='(' || chArr[i]=='[' || chArr[i]=='{' ){
				stack.push(chArr[i]);
			}
			else{
				if(stack.isEmpty()){
					balanced = false;
				}
				else{
					char ch = stack.pop();
//					switch(chArr[i]){
//						case ')':
//							if(ch!='(')
//								balanced = false;
//							break;
//						case ']':
//							if(ch!='[')
//								balanced = false;
//							break;
//						case '}':
//							if(ch!='{')
//								balanced = false;
//							break;
//						default:
//							break;
//					}
					if((chArr[i]==')' && ch!='(')
							|| (chArr[i]==']' && ch!='[')
							|| (chArr[i]=='}' && ch!='{')){
						balanced = false;
					}
				}
			}
		}
		if(!stack.isEmpty()){
			balanced = false;
		}
		
		if(balanced){
			System.out.println("Balanced");
		}
		else{
			System.out.println("Not Balanced");
		}
		
		scanner.close();
	}

}
