package com.xiaren;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Background {

	private String backgroundimage;

	public FileHandle Background(String imagetoload) {

		// This constructor will load a file into memory, so that the
		// class can read the file's entire contents, bit by bit, as
		// in assembly language parsing data structures and file formats.

		this.backgroundimage = imagetoload;
		FileHandle fhimage = null;

		try {
			fhimage = Gdx.files.getFileHandle(imagetoload, Files.FileType.Internal);
			return fhimage;
		} catch (GdxRuntimeException e) {
			System.err.println(e);
			return fhimage;
		}
	}

}
