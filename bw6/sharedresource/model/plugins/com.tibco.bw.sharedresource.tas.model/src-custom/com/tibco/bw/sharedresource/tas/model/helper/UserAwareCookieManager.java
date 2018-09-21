package com.tibco.bw.sharedresource.tas.model.helper;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UserAwareCookieManager extends CookieManager {

	protected UserAwareCookieStore cookieStore;
	protected ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public UserAwareCookieManager() {
		this(new UserAwareCookieStore(), CookiePolicy.ACCEPT_ALL);
	}

	public UserAwareCookieManager(UserAwareCookieStore cookieStore, CookiePolicy cookiePolicy) {
		super(cookieStore, cookiePolicy);
		this.cookieStore = cookieStore;
	}

	public void acquire(String username) {
		this.lock.writeLock().lock();
		this.cookieStore.setCurrentCookieStore(username);
	}

	public void release() {
		this.lock.writeLock().unlock();
	}

	public void printCookies() {
		if (this.cookieStore == null) {
			throw new IllegalStateException("cookieStore is null.");
		}

		Map<String, CookieStore> usernameToCookieStoreMap = this.cookieStore.getCookieStoreMap();
		if (usernameToCookieStoreMap != null) {
			for (Iterator<String> usernameItor = usernameToCookieStoreMap.keySet().iterator(); usernameItor.hasNext();) {
				String username = usernameItor.next();
				CookieStore userCookieStore = usernameToCookieStoreMap.get(username);
				printCookie(username, userCookieStore);
			}
		}
	}

	public void printCookies(String username) {
		if (username == null) {
			throw new IllegalArgumentException("username is null.");
		}

		Map<String, CookieStore> usernameToCookieStoreMap = this.cookieStore.getCookieStoreMap();
		if (usernameToCookieStoreMap != null) {
			CookieStore userCookieStore = usernameToCookieStoreMap.get(username);
			printCookie(username, userCookieStore);
		}
	}

	protected void printCookie(String username, CookieStore cookieStore) {
		List<HttpCookie> cookieList = cookieStore.getCookies();
		if (cookieList == null) {
			System.out.println("Username: " + username + ", HttpCookie list is null.");
			return;
		}

		System.out.println("Username: " + username + ", Number of cookies: " + cookieList.size());
		System.out.println("====================================================================================");
		int index = 0;
		for (HttpCookie cookie : cookieList) {
			if (index > 0) {
				System.out.println();
			}
			System.out.println("Cookie[" + index + "]: ");
			System.out.println("\tDomain: " + cookie.getDomain());
			System.out.println("\tMax age: " + cookie.getMaxAge());
			System.out.println("\tServer path: " + cookie.getPath());
			System.out.println("\tIs sent with secure protocol: " + cookie.getSecure());
			System.out.println("\tName: " + cookie.getName());
			System.out.println("\tValue: " + cookie.getValue());
			System.out.println("\tVersion: " + cookie.getVersion());
			index++;
		}
		System.out.println("====================================================================================");
		System.out.println();
	}

}
