package uf3;

import java.net.*;

public class TestInetAddress {
	public static void main (String[] args) {
		InetAddress dir = null;
		System.out.println("=====================================================");
		System.out.println("SORTIDA PER A LOCALHOST");
		
		try {
			//LOCALHOST
			dir = InetAddress.getByName("localhost");
			provaTots(dir);
			
			//URL www.google.com
			System.out.println("=====================================================");
			System.out.println("SORTIDA PER A URL");
			dir = InetAddress.getByName(args[0]);
			provaTots(dir);
			
			//Array tipus InetAddress amb totes les adreces IP de google.com
			System.out.println("\tAdreces IP per a: "+dir.getHostName());
			InetAddress[] adreces = InetAddress.getAllByName(dir.getHostName());
			for (int i=0; i<adreces.length; i++) 
				System.out.println("\t\t"+adreces[i].toString());
			System.out.println("Retorna un array amb totes les adreces IP que té el host");
			System.out.println("=====================================================");
			
		} catch (UnknownHostException e1) {e1.printStackTrace();}
		
	}
	
	private static void provaTots(InetAddress dir) {
		
		InetAddress dir2;
		
		System.out.println("\tMètode getByName(): "+dir);
		
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tMètode getLocalHost(): "+dir2);
			System.out.println("Retorna el nom i la IP del PC des d'on executem aquest programa");
		} catch (UnknownHostException e) {e.printStackTrace();}
		
		//FEM SERVIR MÊTODES DE LA CLASSE
		System.out.println("\tMètode getHostName(): "+dir.getHostName()+" -->Retorna el nom del host");
		System.out.println("\tMètode getHostAddress(): "+dir.getHostAddress()+" -->Retorna la IP del host");
		System.out.println("\tMètode toString(): "+dir.toString()+" ");
		System.out.println("\tMètode getCanonicalHostName(): "+dir.getCanonicalHostName());
		byte[] getAddress = dir.getAddress();
		System.out.print("\tMètode getAddress(): ");
		for (int i = 0; i < getAddress.length-1; i++) {
			System.out.print(getAddress[i]+".");
		}
		System.out.print(getAddress[3]);
		System.out.println(" Retorna un array en bits de l'adreça IP");
		
	}
}
