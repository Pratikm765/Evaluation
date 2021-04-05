package com.project.pavani.config;

/**
 * @author ayush.pandey
 */
public interface ProjectPavaniDefaults {

	interface Security {

		interface Authentication {

			interface Jwt {

				String secret = null;
				String base64Secret = null;
				long tokenValidityInSeconds = 1800; // 30 minutes
				long tokenValidityInSecondsForRememberMe = 2592000; // 30 days
			}
		}

	}

	interface SMTP{
		String username = null;
		String password = null;
		String host = null;
		Integer port = null;
	}
}
