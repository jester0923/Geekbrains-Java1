/*
* Created by Dmitriy Kirpichnikov 09.10.2016
*/
import java.util.Scanner;

public class dz2
{
	public static void main (String[] args) 
		{
			Scanner sc = new Scanner(System.in); 
			System.out.println("����������� ���. ���������� ������� � ������� ��� ���������.");
			System.out.println("1 - �������� �������, ���������� �� ��������� 0 � 1.");
			System.out.println("2 - ������ ��������� ������� �� ������� 1 �� ���������������");
			System.out.println("3 - ���������� ������� �� 8 ����� �����");
			System.out.println("4 - ������ �� ��������� �������, �������� < 6 �������� �� 2");
			System.out.println("5 - � �������� ������� ����� min � max ��������");
			int s = sc.nextInt();                
			switch (s) 
			{
			case 1:
				{
				System.out.println	("������� - 1")	;
				int[] array1 = {1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1};
					for (int i = 0; i <= 11 ; i++) 
						System.out.println ("a[" + i +"]=" + array1[i] + " ");
				break;
				} 
			case 2:
			{
				System.out.println	("������� - 2")	;
				int[] array1 = {1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1};
				for (int i = 0; i <= 11 ; i++) 
				{
					System.out.print ("a[" + i +"]=" + array1[i] + " ");	
					if (array1[i] == 1)
				{
					array1[i] = 0; 
				}
					else
				{	
					array1[i] = 1;
					}		
					System.out.println ("a[" + i +"]=" + array1[i] + " ");
					}
			break;
				} 
			case 3:
			{
				System.out.println	("������� - 3")	;
				int a = 1;
				int[] array2 = new int [8];
				for (int i = 0; i <= 7 ; i=i+1) 
				{
				array2[i] = a;
				a = a + 3;
				System.out.println ("a[" + i +"]=" + array2[i] + " ");	
				}
			break;
			}
			
			case 4:
			{
				System.out.println	("������� - 4")	;
				int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
				for (int i = 0; i <= 11 ; i++) 
				{
				System.out.print ("a[" + i +"]=" + array3[i] + " ");	
				if (array3[i] < 6)
				{
					array3[i] = array3[i] * 2; 
				}
				System.out.println ("a[" + i +"]=" + array3[i] + " ");
				}
			break;
			}
			
			case 5:
			{
				System.out.println	("������� - 5")	;
				int[] array4 = {4, 7, 13, 15, 8, 3, 2, 16, 9, 11, 12, 35 };
				int max = array4[0];
				int min = array4[0];
				for (int i = 0; i <= 11 ; i++) 
				{
				System.out.println ("a[" + i +"]=" + array4[i] + " ");	
				if (array4[i] > max)
				{
					max = array4[i]; 
				}
				else
				if (array4[i] < min)
					min = array4[i]; 
				}
				System.out.println ("max =" + max +" min = " + min);
			break;
			} 
			}
		}
} 

//������� 6** ������� ��������� ������� � �����������. 