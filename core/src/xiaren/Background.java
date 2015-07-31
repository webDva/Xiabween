package xiaren;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Background {

	private final String backgroundimage;

	public Background(String imagetoload) { // imagetoload is the file path of the image to load.

		this.backgroundimage = imagetoload;

	}

	public FileHandle loadFIle() {

		// This method will load a file into memory, so that the
		// class can read the file's entire contents, bit by bit, as
		// in assembly language parsing data structures and file formats.

		FileHandle fhimage = null;

		try {
			fhimage = Gdx.files.getFileHandle(this.backgroundimage, Files.FileType.Internal);
			return fhimage;
		} catch (GdxRuntimeException e) {
			System.err.println(e);
			return fhimage;
		}
	}

}
