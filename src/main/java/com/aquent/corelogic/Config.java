package com.aquent.corelogic;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "aquent.corelogic")
@Component

public class Config {

		private String publickeyfileName;

		public String getPublickeyfileName() {
			return publickeyfileName;
		}

		public void setPublickeyfileName(String publickeyfileName) {
			this.publickeyfileName = publickeyfileName;
		}

}


