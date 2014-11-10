package com.fmatos.gaeSample.downloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;


import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;

/**
 * @author fdematos
 *
 */

abstract public class AbstractRssDownloader implements ImageDownloader {

		private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRssDownloader.class);
		
		abstract public String getFeedUrl() ;
		abstract public Album processFeed(SyndFeed syndFeed);

		
		public String getGenericImageFinder() {
			return ".*(<img src=[\"\'])(http://[-/\\.\\w]*).*>";
		}
		
		public String getRandomPhotoUrl() {

			Album album = getRandomAlbum();
			if ( album.getPhotos() != null && album.getPhotos().size() > 0) {
				return album.getPhotos().get(0);
			} else {
				return null;
			}
		}

		public Album getRandomAlbum() {
			return doAll();
		}

		private Album doAll() {

			try {
				String url = getFeedUrl();
 
				SyndFeed feed = buildSyndFeed(url );
				LOGGER.info("Got feed from " + url);
				
				return processFeed(feed);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		private SyndFeed buildSyndFeed(String url) {
			URLConnection openConnection;
			try {
				openConnection = new URL(url).openConnection();
				InputStream is = new URL(url).openConnection().getInputStream();

				if("gzip".equals(openConnection.getContentEncoding())){
					is = new GZIPInputStream(is);
				}            

				InputSource source = new InputSource(is);            
				SyndFeedInput input = new SyndFeedInput();
				SyndFeed feed = input.build(source);

				return feed;

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (FeedException e) {
				e.printStackTrace();
			}            

			return null;
		}


	}
