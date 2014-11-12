package com.fmatos.gaeSample.downloader;

public class Photo {

	private String url;
	private String caption;
	private String link;
	
	public Photo(String url, String caption) {
		this.url = url;
		this.caption = caption;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getCaption() {
		return caption;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	@Override
	public String toString() {
		return "Photo [url=" + url + ", caption=" + caption + ", link=" + link
				+ "]";
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
