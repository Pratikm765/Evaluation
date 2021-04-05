package com.project.pavani.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ayush.pandey
 */
@Component
@ConfigurationProperties("pavani")
public class ProjectPavaniProperties {
	private final Security security = new Security();
	private final SMTP smtp = new SMTP();

	public static class Security {

		private final Authentication authentication = new Authentication();

		public Authentication getAuthentication() {
			return authentication;
		}

		public static class Authentication {

			private final Jwt jwt = new Jwt();

			public Jwt getJwt() {
				return jwt;
			}

			public static class Jwt {

				private String secret = ProjectPavaniDefaults.Security.Authentication.Jwt.secret;

				private String base64Secret = ProjectPavaniDefaults.Security.Authentication.Jwt.base64Secret;

				private long tokenValidityInSeconds = ProjectPavaniDefaults.Security.Authentication.Jwt
															  .tokenValidityInSeconds;

				private long tokenValidityInSecondsForRememberMe = ProjectPavaniDefaults.Security.Authentication.Jwt
																		   .tokenValidityInSecondsForRememberMe;

				public String getSecret() {
					return secret;
				}

				public void setSecret(String secret) {
					this.secret = secret;
				}

				public String getBase64Secret() {
					return base64Secret;
				}

				public void setBase64Secret(String base64Secret) {
					this.base64Secret = base64Secret;
				}

				public long getTokenValidityInSeconds() {
					return tokenValidityInSeconds;
				}

				public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
					this.tokenValidityInSeconds = tokenValidityInSeconds;
				}

				public long getTokenValidityInSecondsForRememberMe() {
					return tokenValidityInSecondsForRememberMe;
				}

				public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
					this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
				}
			}
		}
	}

	public static class SMTP {
		private String username = ProjectPavaniDefaults.SMTP.username;
		private String password = ProjectPavaniDefaults.SMTP.password;
		private String host = ProjectPavaniDefaults.SMTP.host;
		private Integer port = ProjectPavaniDefaults.SMTP.port;

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public Integer getPort() {
			return port;
		}
		public void setPort(Integer port) {
			this.port = port;
		}
	}

	/**
	 * <p>Getter for the field <code>security</code>.</p>
	 *
	 * @return a {ProjectPavaniProperties.Security} object.
	 */
	public Security getSecurity() {
		return security;
	}

	/**
	 * <p>Getter for the field <code>smtp</code>.</p>
	 *
	 * @return a {ProjectPavaniProperties.SMTP} object.
	 */
	public SMTP getSmtp() { return smtp; }
}
