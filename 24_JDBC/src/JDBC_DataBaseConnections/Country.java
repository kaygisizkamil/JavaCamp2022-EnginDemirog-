package JDBC_DataBaseConnections;

public class Country {
			String code;
			String name;
			String continent;
			String region;
			public Country(String code, String name, String continent, String region) {
				//super();
				this.code = code;
				this.name = name;
				this.continent = continent;
				this.region = region;
			}
			public Country(String name,String code) {
				this.name=name;
				this.code=code;
			}
}
