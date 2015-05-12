package by.epam.enumiration;

public enum Color {
	
	/*Green,
	Yellow,
	Red,
	Blue,
	Pink,
	White;*/
	
	Green("GREEN"),
	Yellow("YELLOW"),
	Red("RED"),
	Blue("BLUE"),
	Pink("PINK"),
	White("WHITE");
	
	private final String name;
	
	private Color(String name) {
		this.name = name;
	}
	
	public static Color getColor(String col) {
		for(Color color : values()) {
			if(color.name.equalsIgnoreCase(col)) {
				return color;
			}
		}
		return null;
	}
}
