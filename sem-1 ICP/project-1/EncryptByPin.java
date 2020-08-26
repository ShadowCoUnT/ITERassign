//  ABDULLAH TABISH 
	// REG. NO. 1941012375 
		// CSE 'K' 

import java.util.Scanner;
public class EncryptByPin 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the value of 'n' : ");
		int n=in.nextInt();
								
			System.out.print("\nEnter the 1st number of "+n+" digit : " );
			int n1=in.nextInt();
			System.out.print("Enter the 2nd number of "+n+" digit : " );
			int n2=in.nextInt();
			System.out.print("Enter the 3rd number of "+n+" digit : " );
			int n3=in.nextInt();
			System.out.print("Enter the 4th number of "+n+" digit : " );
			int n4=in.nextInt();
								
				int m=0,r1,r2,r3,r4;
				int nn1,min,q=1;
				char encryptedchar = 0;
				nn1=n1;
				int pin =0;
		
					for(int a1=1;nn1!=0;a1++)
						
						{
							nn1=nn1/10;
							m++;
						}
		
							for(int mm=1;mm<=m;mm++)
								
								{
									r1=n1%10;
									n1=n1/10;
									r2=n2%10;
									n2=n2/10;
									r3=n3%10;
									n3=n3/10;
									r4=n4%10;
									n4=n4/10;
									min=Math.min(r1, Math.min(r2, Math.min(r3, r4)));
									pin=(int)( pin + min*Math.pow(10, (mm-1)));
								}
							
										System.out.println("\n\nGenerated pin is "+pin);
										Scanner Str=new Scanner(System.in);
										System.out.print("\n\nEnter a Message To Encrypt : ");
										String message=Str.nextLine();
										System.out.print("\n\nEncrypted message is - ");
										String word = message.replaceAll(" ", "").toLowerCase();
										int length = word.length();
										for(int len=1;len<=length;len++)
											
											{
												if(q-1>=m)
													
													{
														q=1;	
													}
												
												int ab =(int)(( pin/(Math.pow(10, m-q))%10));
												char mes = word.charAt((len-1));
												char capital=(char)(mes-32);
												int noo=mes-32+ab;
												if(noo>90)
													
												{
													int alpha=(noo)-90;
													encryptedchar = ((char)(64+alpha));
													System.out.print(encryptedchar);
												}
													
													else
														
												{
													encryptedchar = (char)( ((capital)+ab));
													System.out.print(encryptedchar);
												}
												
												q++;		
											}
	}
}