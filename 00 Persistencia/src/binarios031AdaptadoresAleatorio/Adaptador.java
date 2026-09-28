package binarios031AdaptadoresAleatorio;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Adaptador {

	public Cliente leer(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean grabar(String path, Cliente objeto) {
		assert path != null && objeto != null;
		File file = new File(path);
		boolean retorno = false;
		//abre y cierra tras el try
		try(RandomAccessFile flujoW= new RandomAccessFile(file,"rw")) {
			flujoW.seek(flujoW.length());
			flujoW.writeInt(objeto.getNumero());
			flujoW.writeUTF(objeto.getNombre());
			flujoW.writeBoolean(objeto.isPreferente());
			flujoW.writeFloat(objeto.getSaldo());
			retorno = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}

}
