package binarios033AdaptadoresAleatorioMapeoPersistenteBorradoMetodoDosREcompactar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class Adaptador {

	private AccesorRamdon mapa;
	private File accesorFile;

	public Adaptador(String pathAccesor) {
		super();
		accesorFile = new File(pathAccesor);
		if (!accesorFile.exists())
			try {
				accesorFile.createNewFile();
				mapa = new AccesorRamdon();
				new ObjectOutputStream(new FileOutputStream(accesorFile)).writeObject(mapa);
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			try {
				mapa = (AccesorRamdon) new ObjectInputStream(new FileInputStream(accesorFile)).readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				mapa = new AccesorRamdon();
				try {
					new ObjectOutputStream(new FileOutputStream(accesorFile)).writeObject(mapa);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}

	public Cliente leer(String path, int posicion) {
//		assert path != null && posicion>=0&&indice.containsKey(posicion);
		File file = new File(path);
		Cliente retorno = null;
		try (RandomAccessFile flujoR = new RandomAccessFile(file, "r")) {
			Long pos = mapa.get(posicion);
			flujoR.seek(pos);
			retorno = new Cliente(flujoR.readInt(), flujoR.readUTF(), flujoR.readBoolean(), flujoR.readFloat());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean grabar(String path, Cliente objeto) {
//		assert path != null && objeto != null;
		File file = new File(path);
		boolean retorno = false;
		// abre y cierra tras el try
		try (RandomAccessFile flujoW = new RandomAccessFile(file, "rw")) {
			long length = flujoW.length();
			System.out.println("grabacion numero " + mapa.getPosicion() + " longitud:" + length);
			flujoW.seek(length);
			flujoW.writeInt(objeto.getNumero());
			flujoW.writeUTF(objeto.getNombre());
			flujoW.writeBoolean(objeto.isPreferente());
			flujoW.writeFloat(objeto.getSaldo());
			mapa.put(length);
			FileOutputStream out = new FileOutputStream(accesorFile);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(mapa);
			objectOutputStream.close();
			retorno = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public Long delete(String path, int posicion) {
		Long remove = mapa.remove(posicion);
		File fileOri = new File(path);
		File fileTemp = new File(path + ".tmp");
		//se vuelca el archivo en otro temporal
		if (remove != null) {
			try (RandomAccessFile flujoR = new RandomAccessFile(fileOri, "r");
					RandomAccessFile flujoW = new RandomAccessFile(fileTemp, "rw")) {
				for (int i = 0; i < mapa.getPosicion(); i++) {
					if (i != posicion) {
						Long pos = mapa.get(i);
						flujoR.seek(pos);
						Cliente objeto = new Cliente(flujoR.readInt(), flujoR.readUTF(), flujoR.readBoolean(),
								flujoR.readFloat());
						flujoW.writeInt(objeto.getNumero());
						flujoW.writeUTF(objeto.getNombre());
						flujoW.writeBoolean(objeto.isPreferente());
						flujoW.writeFloat(objeto.getSaldo());
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//borramos el original y renombramos el fichero temp
		fileOri.delete();
		fileTemp.renameTo(fileOri);
		
		return remove;
	}
}
