public class Hoinka {
	public static void main(String[] args){
		System.out.println("Hello, World!");
		if(args.length==1){
			int myint;
			myint = Integer.parseInt(args[0]);
			for(int i=1;i<=myint;i++){
				String a="";
				for(int j=0;j<i;j++){
					a+="*";
					
				}
				System.out.println(a);
			}
		}
	}
}