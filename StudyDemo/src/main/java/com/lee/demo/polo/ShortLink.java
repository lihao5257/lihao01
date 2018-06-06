package com.lee.demo.polo;

public class ShortLink {
	private Long id;

	private String shortKey;

	private String originalUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortKey() {
		return shortKey;
	}

	public void setShortKey(String shortKey) {
		this.shortKey = shortKey == null ? null : shortKey.trim();
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl == null ? null : originalUrl.trim();
	}
}