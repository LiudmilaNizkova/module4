package by.epam.enumiration;

public enum Freshness {
	/*FullFresh,
	MiddleFresh,
	OldFresh;*/
	FullFresh("FULLFRESH"),
	MiddleFresh("MIDDLEFRESH"),
	OldFresh("OLDFRESH");
	
private final String name;
	
	private Freshness(String name) {
		this.name = name;
	}
	
	public static Freshness getFresh(String fr) {
		for(Freshness fresh : values()) {
			if(fresh.name.equalsIgnoreCase(fr)) {
				return fresh;
			}
		}
		return null;
	}
}
