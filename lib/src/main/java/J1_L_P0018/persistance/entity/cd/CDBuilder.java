package J1_L_P0018.persistance.entity.cd;

public class CDBuilder {
	// format: CD-#### with # as digit
	private String id;

	// collection name (game/movie/music)
	private CDCollectionName cDCollectionName;

	// type
	private CDType type;
	
	// title
	private String title;

	// unit price
	private float price;

	// publication year
	private int year;

	// constructor
	public CDBuilder() {
		this.id = "";
		this.cDCollectionName = CDCollectionName.UNKNOWN;
		this.type = CDType.UNKNOWN;
		this.title = "";
		this.price = 0;
		this.year = 0;
	}

	// sets ID
	public final CDBuilder setID(String id) {
		this.id = id;
		return this;
	}

	// sets collection name
	public final CDBuilder setCollectionName(CDCollectionName cDCollectionName) {
		this.cDCollectionName = cDCollectionName;
		return this;
	}

	// sets type
	public final CDBuilder setType(CDType type) {
		this.type = type;
		return this;
	}
	
	// sets title
	public final CDBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	// sets price
	public final CDBuilder setPrice(float price) {
		this.price = price;
		return this;
	}

	// sets year
	public final CDBuilder setYear(int year) {
		this.year = year;
		return this;
	}

	// builds CD
	public final CD build() {
		CD cd = new CD(id, cDCollectionName, type, title, price, year);
		clear();

		return cd;
	}

	// clears CDBuilder
	public final void clear() {
		this.id = "";
		this.cDCollectionName = CDCollectionName.UNKNOWN;
		this.type = CDType.UNKNOWN;
		this.price = 0;
		this.year = 0;
	}
}
