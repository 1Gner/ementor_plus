package main;

import java.util.ArrayList;

import error.SaveError;
import view.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SaveError svE = new SaveError();
		ArrayList<String> err = new ArrayList<String>();

		try {
			Usuario user = new Usuario();
			user.setVisible(true);


		}catch(Throwable t) {
			System.err.println("Um erro ocorreu: " + t.getMessage());
			err = (ArrayList<String>) svE.lerDoDisco("erros.dat", err);
			err.add(t.getMessage());
			svE.salvarEmDisco("erros.dat", err);
		}
	}


}


