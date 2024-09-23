package error;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveError {
	public void salvarEmDisco(String nomearquivo, ArrayList<?> lista) {
		File arquivo = new File(nomearquivo);

		try {
			FileOutputStream fout = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fout);

			oos.writeObject(lista);

			oos.flush();
			oos.close();
			fout.close();

		} catch (Exception ex) {
			System.err.println("error: " + ex.toString());
		}

	}

	public ArrayList<?> lerDoDisco(String nomearquivo, ArrayList<?> lista) {
		File arquivo = new File(nomearquivo);
		try {
			FileInputStream fin = new FileInputStream(arquivo);
			ObjectInputStream oin = new ObjectInputStream(fin);

			lista = (ArrayList<?>) oin.readObject();

			oin.close();
			fin.close();

			return lista;

		} catch (FileNotFoundException ex) {
			System.err.println("Lista vazia ou nao criada");


		} catch(Exception ex) {
			System.err.println("Erro: " + ex.toString());
		}

		return lista;
	}

	public void Imprimirlista(ArrayList<?> lista) {

		for (Object x : lista) {
			System.out.println(x);
		}

	}
}
