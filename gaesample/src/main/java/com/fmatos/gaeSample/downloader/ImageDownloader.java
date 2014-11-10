package com.fmatos.gaeSample.downloader;

import java.util.List;

public interface ImageDownloader {
	
	/**
	 * Returns URL of a random photo
	 * @return URL where the photo is
	 * @throws DownloaderException to indicate any internal error 
	 * from the chosen Downloader
	 */
	public String getRandomPhotoUrl();
	
	/** Returns the name of the downloader service **/
	public String getDownloaderName();

	/**
	 * Returns all photo URLs in a random album
	 * @param config
	 * @return list of urls
	 */
	public Album getRandomAlbum();
	
	
}

