package main;

import java.awt.EventQueue;

import modeli.Centrala;
import prozori.LoginProzor;

public class Main {
	
	public static void main(String[] args) {
		
		Centrala centrala = Centrala.getInstance();		

		EventQueue.invokeLater(() -> {
			LoginProzor ex = new LoginProzor();
			ex.setVisible(true);
		});
    }
}