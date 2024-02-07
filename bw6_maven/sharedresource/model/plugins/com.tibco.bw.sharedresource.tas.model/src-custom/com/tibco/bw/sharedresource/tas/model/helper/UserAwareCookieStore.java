package com.tibco.bw.sharedresource.tas.model.helper;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAwareCookieStore implements CookieStore {

	protected CookieStore defaultCookieStore = new CookieManager().getCookieStore();
	protected Map<String, CookieStore> usernameToCookieStoreMap = new HashMap<String, CookieStore>();

	protected String currUsername;
	protected CookieStore currUserCookieStore;

	public Map<String, CookieStore> getCookieStoreMap() {
		return this.usernameToCookieStoreMap;
	}

	public void setCurrentCookieStore(String username) {
		if (username == null) {
			this.currUsername = null;
			this.currUserCookieStore = null;

		} else {
			this.currUsername = username;
			CookieStore userCookieStore = this.usernameToCookieStoreMap.get(this.currUsername);
			if (userCookieStore == null) {
				userCookieStore = new CookieManager().getCookieStore();
				this.usernameToCookieStoreMap.put(username, userCookieStore);
			}
			this.currUserCookieStore = userCookieStore;
		}
	}

	public String getCurrentUsername() {
		return this.currUsername;
	}

	public CookieStore getCurrentCookieStore() {
		return this.currUserCookieStore;
	}

	private CookieStore get() {
		if (this.currUsername != null && this.currUserCookieStore != null) {
			return this.currUserCookieStore;
		}
		return this.defaultCookieStore;
	}

	public void add(URI uri, HttpCookie cookie) {
		get().add(uri, cookie);
	}

	public List<HttpCookie> get(URI uri) {
		return get().get(uri);
	}

	public List<HttpCookie> getCookies() {
		return get().getCookies();
	}

	public List<URI> getURIs() {
		return get().getURIs();
	}

	public boolean remove(URI uri, HttpCookie cookie) {
		return get().remove(uri, cookie);
	}

	public boolean removeAll() {
		return get().removeAll();
	}

}
