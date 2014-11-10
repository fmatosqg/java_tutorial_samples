package com.fmatos.gaeSample.downloader;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;

public class JPLDownloader extends AbstractRssDownloader {

	private static final Logger LOGGER = LoggerFactory.getLogger(JPLDownloader.class);
	
	@Override
	public String getDownloaderName() {
		return "JPL photo journal";
	}

	@Override
	public String getFeedUrl() {
		return "http://photojournal.jpl.nasa.gov/rss/new";
	}

	@Override
	public Album processFeed(SyndFeed syndFeed) {
		{
			LOGGER.info("Links " + syndFeed.getLink());

			List<String> urls = new LinkedList<String>();
			Album album = new Album();
			album.setPhotos(urls);

			String photoPattern = getGenericImageFinder(); 
			//                           			<img src='http://photojournal.jpl.nasa.gov/thumb/PIA18828.jpg' height='100' width='142' border='0' style='vertical-align:middle' alt='' /
			LOGGER.info("pattern for photo url is " + photoPattern);
			Pattern photo = Pattern.compile(photoPattern);

			List<? extends SyndEntryImpl> list = syndFeed.getEntries();

			for(SyndEntryImpl entry: list){
				String html = entry.getDescription().getValue();
				
				Matcher str = photo.matcher(html);
				
				if ( str.find()) {
					String url = str.group(2);
					LOGGER.debug("found url {} "  , url);
					urls.add(url);
				}
				
			}
			
			
			return album;
		}
	}

}
