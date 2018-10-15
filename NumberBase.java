package MyPac;

public class NumberBase {
		public static String convert(String input, int base_in, int base_out){
			String r = "";
			if((base_in!=10)&&(base_out!=10)){
				r = toDec(input,base_in);
				return fromDec(r,base_out);
			}else if(base_in==10){
				return fromDec(input,base_out);
			}else if(base_out==10){
				return toDec(input,base_in);
			}
			return toDec(input,base_out);
		}
		/*	This helper method will take a base 10 number and return the 
		 * 	number in the base given to it
		 */
		private static String fromDec(String in, int base){
			int numb = 0,n=in.length()-1; //numb will be used for returning the result, n for the equation
			String result = "";
			//This will convert a string number to an int for calculating
			for(int i=0;i<in.length();i++){
				numb = (int) ((in.charAt(i)-48)*(Math.pow(10,n)))+numb;
				n--;
			}
			//This does the equation and converts it back to string to return
			while(numb!=0){
				result = (numb%base)+ "" + result;
				numb = numb/base;
			}
			return result;
		}
		
		public static String toDec(String input,int base){
			int n = input.length() - 1,numb=0;
			String result = "";
			//This will convert if the base is greater than 10
			input = input.toLowerCase();
			if(base>10){
				for(int i = 0;i<input.length();i++){
					if((input.charAt(i) >= 97) && (input.charAt(i)<=(16-1-10+97))){
						//System.out.println("Hello there" + (input.charAt(i)+10-97));
						numb = numb + (int)((input.charAt(i)+10-97)*Math.pow(base,n));
						n--;
					}else if((input.charAt(i) > 47) && (input.charAt(i)<58)){
						numb = numb + (int)((input.charAt(i)-48)*Math.pow(base,n));
						n--;
					}else{
						System.out.println("Failure");
					}
				}
			}else{
				//This for loop will convert the number in the string to 
				//an int in base 10
				for(int i = 0;i<input.length();i++){
					numb = numb + (int)((input.charAt(i)-48)*Math.pow(base,n));
					n--;
				}
			}
			//This does the equation and converts it back to string to return
			result = numb + "";
			return result;
		}
}



