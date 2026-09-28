package binarios032AdaptadoresAleatorioMapeo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class Adaptador {
	
	//////////////Juntar estas dos cosas
	static int posicion=0; 
	//habria que persistir el indice
	HashMap<Integer, Long> indice=new HashMap<>();
	///////////////////////////////////////////////

	public Cliente leer(String path,int posicion) {
//		assert path != null && posicion>=0&&indice.containsKey(posicion);
		File file = new File(path);
		Cliente retorno=null;
		try(RandomAccessFile flujoR= new RandomAccessFile(file,"r")) {
			Long pos = indice.get(posicion);
			flujoR.seek(pos);
			retorno=new Cliente(flujoR.readInt(),flujoR.readUTF(),flujoR.readBoolean(),flujoR.readFloat());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean grabar(String path, Cliente objeto) {
//		assert path != null && objeto != null;
		File file = new File(path);
		boolean retorno = false;
		//abre y cierra tras el try
		try(RandomAccessFile flujoW= new RandomAccessFile(file,"rw")) {
			long length = flujoW.length();
			flujoW.seek(length);
			flujoW.writeInt(objeto.getNumero());
			flujoW.writeUTF(objeto.getNombre());
			flujoW.writeBoolean(objeto.isPreferente());
			flujoW.writeFloat(objeto.getSaldo());
			indice.put(posicion++, length);
			retorno = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}

}
