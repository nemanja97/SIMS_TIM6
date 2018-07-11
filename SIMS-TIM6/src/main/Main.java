package main;

import java.awt.EventQueue;

import prozori.LoginProzor;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			LoginProzor ex = new LoginProzor();
			ex.setVisible(true);
		});
    }
}